package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withCategoryId(params.getCategoryId()).and(withPriceGt(params.getPriceGt()))
                .and(withPriceLt(params.getPriceLt())).and(withRatingGt(params.getRatingGt()))
                .and(withTitleContainingIgnoreCase(params.getTitleCont()));
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, cb) -> priceGt == null ? cb.conjunction() : cb.greaterThan(root.get("price"), priceGt);
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, criteriaBuilder) -> priceLt == null ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("price"), priceLt);
    }

    private Specification<Product> withRatingGt(Double ratingGt) {
        return (root, query, criteriaBuilder) -> ratingGt == null ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("rating"), ratingGt);
    }

    private Specification<Product> withTitleContainingIgnoreCase(String substring) {
        return (root, query, cb) -> substring == null ?
                cb.conjunction() :
                cb.like(cb.lower(root.get("title")), "%" + substring.toLowerCase() + "%");
    }
}
// END
