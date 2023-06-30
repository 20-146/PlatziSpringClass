package quanam.platzispringclass.domain;

import lombok.Data;

@Data
public class Category {
    private Integer categoryId;
    private String category;
    private Boolean active;
}
