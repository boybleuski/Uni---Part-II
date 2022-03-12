package lab1;

public class Stack : public Node
{
   private Node head;
   private Node tail;
   private Node current;
   private int size;

   public Stack()
   {
      head = null;
      tail = null;
      current = null;
      size = 0;
   }

   public void Push(Object _data)
   {
      if (head == null)
      {
         Node temp = new Node(_data);
         tail = temp;
         head = temp;
      }
      else
      {
         Node temp = new Node(_data);
         head.setNext(temp);
         temp.setPrev(head);
         head = temp;
      }
      size++;
   }

   public Object Pop()
   {
      if (head != null)
      {
        Object headData = head.getData();
        if (head.getNext() != null)
        {
           head.getNext().setPrev(null);
           head = head.getNext();
        }
        else
        {
           head = null;
           tail = null;
        }
        size--;
        return headData;
      }
      else
        return null;
   }
}
