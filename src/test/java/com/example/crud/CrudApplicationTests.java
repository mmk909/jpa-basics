package com.example.crud;

import com.example.crud.entity.Child;
import com.example.crud.entity.Ingredient;
import com.example.crud.entity.Parent;
import com.example.crud.repos.ChildRepository;
import com.example.crud.repos.IngredientRepo;
import com.example.crud.repos.ParentRepository;
import com.example.crud.service.ParentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
//@ExtendWith(SpringExtension.class)
class CrudApplicationTests {
    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private IngredientRepo ingredientRepo;

    @Test
    public void testJpaInheritance(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName("dog");
        ingredient.setValue(12.0);
        this.ingredientRepo.save(ingredient);
        assertThat(ingredient.getId()).isNotNull();
    }

    @Test
    public void testRelationShip(){

        for (int i = 0; i < 2; i++) {
            Parent parent = new Parent();
            parent.setName("Parent " + i);
            Parent savedParent = parentRepository.save(parent);

            for (int j = 0; j < 3; j++) {
                Child child = new Child();
                child.setName("child" + j);
                child.setParentID(savedParent.getId());
                Child savedChild = childRepository.save(child);
                Parent updaedParent = parentRepository.findById(savedParent.getId()).get();
                List<Child> children = updaedParent.getChildren();
                assertThat(children.size()).isEqualTo(j+1);

            }

        }

    }
    @Test
    public void testReset(){
        List<Parent> persistedParents = parentRepository.findAll();
        parentRepository.deleteAll(persistedParents);
        persistedParents = parentRepository.findAll();
        assertThat(persistedParents.size()).isEqualTo(0);

        parentRepository.resetAutoIncrement("parent", 0);
        parentRepository.resetAutoIncrement("child", 0);
    }
    @Test
    @Transactional
    public void testBatchInsert() {
        List<Parent> persistedParents = parentRepository.findAll();
        parentRepository.deleteAll(persistedParents);
        persistedParents = parentRepository.findAll();
        assertThat(persistedParents.size()).isEqualTo(0);

        parentRepository.deleteAll(persistedParents);

        parentRepository.resetAutoIncrement("parent", 0);
        parentRepository.resetAutoIncrement("child", 0);

        List<Parent> parents = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Parent parent = new Parent();
            parent.setName("Parent " + i);
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < i; x++) {
                sb.append('C');
            }
            for (int j = 0; j < 1000; j++) {
                Child child = new Child();
                child.setName(sb.toString() + j);
                parent.getChildren().add(child);
            }

            parents.add(parent);
        }

        parentService.batchInsert(parents);

        persistedParents = parentRepository.findAll();

        assertThat(persistedParents.size()).isEqualTo(5);
        persistedParents.forEach((p)->{
            assertThat(p.getChildren().size()).isEqualTo(1000);
        });

        List<Child> children = childRepository.findAll();
        assertThat(children.size()).isEqualTo(5000);

    }
}
