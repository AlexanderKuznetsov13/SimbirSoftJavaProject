package ru.alex.kuznetsov.project.simbirsoft.repository.filter;

import org.springframework.data.jpa.domain.Specification;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskEntity;
import ru.alex.kuznetsov.project.simbirsoft.enums.TaskState;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public class TaskFilter implements Specification<TaskEntity> {
    List<Condition> conditions;

    public TaskFilter(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = conditions.stream().map((condition) -> buildPredicate(condition, root, criteriaQuery, criteriaBuilder)).collect(Collectors.toList());

        if (predicates.size() > 1) {
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        } else {
            return predicates.get(0);
        }
    }


    public Predicate buildPredicate(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch(condition.getComparison()) {
            case EQ:
                return buildEqualsPredicate(condition, root, criteriaQuery, criteriaBuilder);
            default:
                return buildEqualsPredicate(condition, root, criteriaQuery, criteriaBuilder);
        }
    }


    private Predicate buildEqualsPredicate(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (condition.getType() == Type.STATE) {
            condition.setValue(TaskState.valueOf((String) condition.getValue()));
        }
        return criteriaBuilder.equal(root.get(condition.getField()), condition.getValue());
    }


}

enum Comparison {
    EQ
}

enum Type {
    STRING,
    NUMERIC,
    STATE
}

