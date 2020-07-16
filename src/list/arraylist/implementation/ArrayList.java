package list.arraylist.implementation;

public class ArrayList {


    private int size = 0;
    private Object[] elementData = new Object[100];

    public boolean addFirst(Object element)
    {
        return add(0, element);
    }

    public boolean addLast(Object element)
    {
        elementData[size] = element;
        size = size + 1;
        return true;
    }

    public boolean add(int index, Object element)
    {

        for(int i = size-1; i >= index; i--)
        {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size = size + 1;
        return true;
    }

    public String toString()
    {
        String str = "[";
        for(int i = 0; i < size; i++)
        {
            str = str + elementData[i];
            if(i < size-1)
            {
                str = str + ",";
            }
        }
        return str + "]";
    }

    public Object remove(int index)
    {
        // Collection Framework의 remove 메서드에는 삭제 된 값을 return 해준다.
        // 삭제 해당 위치 데이터를 삭제하면 그 위치로 빈자리를 메꿔줘야함.
        Object removed = elementData[index];
        for(int i = index+1; i <= size-1; i++)
        {
            elementData[i - 1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size-1);
    }

    public Object get(int index)
    {
        return elementData[index];
    }

    public int size(){ return size; }

    public int indexOf(Object o)
    {
        for(int i = 0; i < size; i++)
        {
            if(o.equals(elementData[i]))
            {
                return i;
            }
        }
        return -1;
    }

    public ListIterator listIterator()
    {
        return new ListIterator();
    }

    class ListIterator {
        private int nextIndex = 0;
        public Object next()
        {
            /*
            Object returnData = elementData[nextIndex];
            nextIndex = nextIndex + 1;
            return returnData;
            */
            return elementData[nextIndex++];
        }

        public boolean hasNext()
        {
            return nextIndex < size();
        }

        // previous 메소드를 호출해도 되는지를 체크합니다.
        public boolean hasPrevious()
        {
            // nextIndex가 0보다 크다면 이전 엘리먼트가 존재한다는 의미입니다.
            return nextIndex > 0;
        }

        // 순차적으로 이전 노드를 리턴합니다.
        public Object previous()
        {
            // 이전 엘리먼트를 리턴하고 nextIndex의 값을 1감소합니다.
            return elementData[--nextIndex];
        }

        // 현재 엘리먼트를 추가합니다.
        public void add(Object element){
            ArrayList.this.add(nextIndex++, element);
        }

        // 현재 엘리먼트를 삭제합니다.
        public void remove(){
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}
