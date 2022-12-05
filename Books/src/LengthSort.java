import java.util.ArrayList;
import java.util.List;

public class LengthSort implements SortingStrategy {

    public LengthSort(){};
    public List<Book> sort(List<Book> currentShelf) {

        if(currentShelf.size() <= 1 || allSameLength(currentShelf)){
            return currentShelf;
        }

        int pivot = currentShelf.size()/2;
        Book pivotBook = currentShelf.get(pivot);

        currentShelf = sortHelper(currentShelf, pivot);
        List<Book> firstHalf = sort(currentShelf.subList(0, currentShelf.indexOf(pivotBook)));
        List<Book> secondHalf = sort(currentShelf.subList(currentShelf.indexOf(pivotBook), currentShelf.size()));

        firstHalf.addAll(secondHalf);
        return firstHalf;
    }

    private boolean allSameLength(List<Book> currentShelf){

        for(int i = currentShelf.size() - 1; i >= 0 ; i--){
            if(currentShelf.get(0) != currentShelf.get(i)){
                return false;
            }
        }

        return true;
    }

    private List<Book> sortHelper(List<Book> list, int pivot){

        ArrayList<Book> leftSide = new ArrayList<Book>();
        ArrayList<Book> rightSide = new ArrayList<Book>();

        for(int i = 0; i < list.size(); i++){

            if(i == pivot){
                continue;
            }

            Book book = list.get(i);

            if(book.getLength() < list.get(pivot).getLength()){
                leftSide.add(book);
            }else{
                rightSide.add(book);
            }
        }

        leftSide.add(list.get(pivot));
        leftSide.addAll(rightSide);

        return leftSide;

    }
}