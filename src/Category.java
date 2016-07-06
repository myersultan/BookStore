/**
 * Created by admin on 7/6/2016.
 */

public enum Category {

    FANTASY(0), FOOD(1), COMPUTERS(2), FICTION(3), HISTORY(4);

    private int id;

    private Category(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

}