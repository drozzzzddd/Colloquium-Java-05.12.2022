import java.util.ArrayList;
import java.util.List;

public class TitleSort implements SortingStrategy {

    public TitleSort(){};
    public List<Book> sort(List<Book> currentShelf) {
        List<Book> newShelf = new ArrayList<Book>();

        for(Book currBook : currentShelf){

            if(newShelf.size() == 0){
                newShelf.add(currBook);
                continue;
            }

            for(int i = 0; i <= newShelf.size(); i++){

                if(i == newShelf.size()){
                    newShelf.add(currBook);
                    break;
                }

                if(alphaOrder(currBook.getTitle(), newShelf.get(i).getTitle())){
                    newShelf.add(i, currBook);
                    break;
                }
            }
        }

        return newShelf;
    }

    private boolean alphaOrder(String firstString, String secondString){

        for(int i = 0; i < firstString.length(); i++){

            char character = firstString.charAt(i);

            if(character < secondString.charAt(i)){
                return true;

            }else if(character > secondString.charAt(i)){
                return false;
            }
        }
        return false;
    }
}