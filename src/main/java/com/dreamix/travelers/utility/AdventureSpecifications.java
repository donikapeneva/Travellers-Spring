package com.dreamix.travelers.utility;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.utility.request.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AdventureSpecifications {

    private SearchCriteria criteria;

    public static Specification<Adventure> hasUserId(Integer userId) {
        return new Specification<Adventure>() {
            @Override
            public Predicate toPredicate(Root<Adventure> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//                    if (criteria.getOperation().equalsIgnoreCase(">")) {
//                        return builder.greaterThanOrEqualTo(
//                                root.<String> get(criteria.getKey()), criteria.getValue().toString());
//                    }
//                    else if (criteria.getOperation().equalsIgnoreCase("<")) {
//                        return builder.lessThanOrEqualTo(
//                                root.<String> get(criteria.getKey()), criteria.getValue().toString());
//                    }
//                    else if (criteria.getOperation().equalsIgnoreCase(":")) {
//                        if (root.get(criteria.getKey()).getJavaType() == String.class) {
//                            return builder.like(
//                                    root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
//                        } else {
//                            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
//                        }
//                    }
//                    return null;
//                }
                System.out.println("root.get(\"Adventure_.userId\") = " + root.get("Adventure_.userId"));
                System.out.println("root.get(\"Adventure.userId\") = " + root.get("Adventure.userId"));
                System.out.println("root.get(\"userId\") = " + root.get("userId"));
                return criteriaBuilder.equal(root.get("Adventure_.userId"), userId );
            }

        };
    }

    public static Specification<Adventure> hasUserSame(Integer userId) {
        return new Specification<Adventure>() {
            @Override
            public Predicate toPredicate(Root<Adventure> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//                    if (criteria.getOperation().equalsIgnoreCase(">")) {
//                        return builder.greaterThanOrEqualTo(
//                                root.<String> get(criteria.getKey()), criteria.getValue().toString());
//                    }
//                    else if (criteria.getOperation().equalsIgnoreCase("<")) {
//                        return builder.lessThanOrEqualTo(
//                                root.<String> get(criteria.getKey()), criteria.getValue().toString());
//                    }
//                    else if (criteria.getOperation().equalsIgnoreCase(":")) {
//                        if (root.get(criteria.getKey()).getJavaType() == String.class) {
//                            return builder.like(
//                                    root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
//                        } else {
//                            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
//                        }
//                    }
//                    return null;
//                }
                System.out.println("root.get(\"Adventure_.userId\") = " + root.get("Adventure_.userId"));
                System.out.println("root.get(\"Adventure.userId\") = " + root.get("Adventure.userId"));
                System.out.println("root.get(\"userId\") = " + root.get("userId"));
                return criteriaBuilder.equal(root.get("Adventure_.userId"), userId );
            }

        };
    }

//    public static Specification<Adventure> isLongTermCustomer() {
//        return new Specification<Adventure> {
//            public Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb) {
//                return cb.lessThan(root.get(Customer_.createdAt), new LocalDate.minusYears(2));
//            }
//        };
//    }
}
