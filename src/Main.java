public class Main {


    public static void main(String[] args) {
        ArrayStack<String> arr1 = new ArrayStack<>();
        arr1.push("ahmed");
        arr1.push("ahmed");


        ArrayStack<String> arr2 = new ArrayStack<>(10);
        arr2.push("ahmed");
        arr2.push("omar");
        arr2.push("omar");
        arr2.push("omar");


        ArrayStack<String> mergedArray = new ArrayStack<>();
        mergedArray.merge(arr1, arr2);
        mergedArray.display();
    }
}