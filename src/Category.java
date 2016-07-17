/**
 * Created by admin on 7/6/2016.
 */

public enum Category {

    FANTASY(0), COMPUTERS(1), FICTION(2), HISTORY(3);

    private int id;

    private Category(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

}