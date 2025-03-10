package org.example.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AbstractJpaSpecification {

    protected Optional<Predicate> unaccentLike(String query, CriteriaBuilder cb, List<Expression<String>> fields) {
        return Optional.ofNullable(query).map(q -> cb.or(
                fields.stream().map(f -> unaccentLike(q, cb, f))
                        .filter(Optional::isPresent).map(Optional::get)
                        .toArray(Predicate[]::new)));
    }

    protected Optional<Predicate> unaccentLike(String q, CriteriaBuilder cb, Expression<String> field) {
        return Optional.ofNullable(q)
                .map(value -> cb.like(unaccent(field, cb), percentEscape(unaccent(cb.literal(value), cb), cb)));
    }

    protected Expression<String> unaccent(Expression<String> expression, CriteriaBuilder cb) {
        return cb.function("unaccent", String.class, cb.function("lower", String.class, expression));
    }

    protected Expression<String> percentEscape(Expression<String> expression, CriteriaBuilder cb) {
        return cb.function("concat", String.class, cb.literal("%"), expression, cb.literal("%"));
    }
}