package com.dreamix.travelers.utility;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.utility.request.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class AdventureSpecifications {

    private SearchCriteria criteria;
    private Specification<Adventure> buildedCriteria;

    public AdventureSpecifications(SearchCriteria criteria) {
        this.criteria = criteria;
        this.buildedCriteria = getEmptyCriteria();
    }

    public Specification<Adventure> getSpecifiedCriteria() {

        if (criteria.getFilterByUser() != null) {
            buildedCriteria = buildedCriteria.and(AdventureSpecifications.hasUserId(criteria.getFilterByUser()));
        }

        if (criteria.getFilterByCity() != null) {
            buildedCriteria = buildedCriteria.and(AdventureSpecifications.hasCityId(criteria.getFilterByCity()));
        }

        if (criteria.getFilterByCountry() != null) {
            buildedCriteria = buildedCriteria.and(AdventureSpecifications.hasCountryId(criteria.getFilterByCountry()));
        }

        if (criteria.getDateFrom() != null) {
            buildedCriteria = buildedCriteria.and(AdventureSpecifications.hasDateRange(criteria.getDateFrom(), criteria.getDateTo()));
        }

        return buildedCriteria;
    }

    public static Specification<Adventure> hasUserId(String id) {
        Integer userId = Utility.stringToInteger(id);

        return new Specification<Adventure>() {
            @Override
            public Predicate toPredicate(Root<Adventure> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                System.out.println("root.get(\"userId\") = " + root.get("user_id"));
                return criteriaBuilder.equal(root.get("user_id"), userId);
            }
        };
    }

    public static Specification<Adventure> hasCityId(String id) {
        Integer cityId = Utility.stringToInteger(id);

        return new Specification<Adventure>() {
            @Override
            public Predicate toPredicate(Root<Adventure> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

//                System.out.println("root.get(\"city_id\") = " + root.get("city_id"));
                return criteriaBuilder.equal(root.get("city_id"), cityId);
            }
        };
    }

    public static Specification<Adventure> hasCountryId(String id) {
        Integer contryId = Utility.stringToInteger(id);

        return new Specification<Adventure>() {
            @Override
            public Predicate toPredicate(Root<Adventure> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                System.out.println("root.get(\"country_id\") = " + root.get("city").get("country_id"));
                return criteriaBuilder.equal(root.get("city").get("country_id"), contryId);
            }
        };
    }

    public static Specification<Adventure> hasDateRange(String dateFromAsString, String dateToAsString) {

        LocalDateTime dateFrom = Utility.stringToLocalDateTime(dateFromAsString);
        LocalDateTime dateTo = Utility.stringToLocalDateTime(dateToAsString);

        return new Specification<Adventure>() {
            @Override
            public Predicate toPredicate(Root<Adventure> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                System.out.println("root.get(\"time between\") = dateFrom= " + dateFrom + " dateTo=" + dateTo);

                return dateFrom != null && dateTo != null ? criteriaBuilder.between(root.get("time"), dateFrom, dateTo)
                        : dateFrom != null ? criteriaBuilder.greaterThanOrEqualTo(root.get("time"), dateFrom)
                        : criteriaBuilder.lessThanOrEqualTo(root.get("time"), dateTo);

            }
        };
    }

    private Specification<Adventure> getEmptyCriteria() {
        return Specification.where(null);
    }

}
