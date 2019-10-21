package be.springPressOrder.domain;

public interface PressOrderCheckService {
//    public String checkMinquantityFruit(int quantityFruit);
//
//    public String checkMaxquantityFruit(int quantityFruit);
//
//    public boolean checkValidRangeQuantity(int quantityFruit);

    public String checkFruitAmount(String fruit, int aantal);

    public boolean checkFruit(String fruit);


}
