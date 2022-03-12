package lab1;

public class Queue : public Node
{
   private Node head;
   private Node tail;
   private Node current;
   private int size;

   public Queue()
   {
      head = null;
      tail = null;
      current = null;
      size = 0;
   }

   public void Push(Object _data)
   {
      Node temp = new Node(_data);
      tail.setPrev(temp);
      temp.setNext(tail);
      tail = temp;
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
        return headData;
      }
      else
        return null;
   }
}
