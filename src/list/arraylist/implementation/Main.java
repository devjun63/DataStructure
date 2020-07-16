package list.arraylist.implementation;

public class Main {
    public static void main(String[] args) {

        ArrayList numbers = new ArrayList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);

        /*for(int i = 0; i < numbers.size(); i++)
        {
            System.out.println(numbers.get(i));
        }
        위 코드 보다 권잗되는 방법이 Iterator
        반복적인 작업을 위해 고안된 객체
        객체지향 프로그래밍에서 지향되는 패턴 Iterator pattern
        */
        ArrayList.ListIterator li = numbers.listIterator();
        while(li.hasNext())
        {
            int number = (int)li.next();
            if(number == 30)
            {
                li.remove();
            }
        }
        System.out.println(numbers);
    }
}
