package lab1;

public class Node
{
   private Node prev;
   private Node next;
   private Object data;

   public Node(Object _data)
   {
      data = _data;
   }

   public Node getPrev()
   {
      return prev;
   }

   public Node getNext()
   {
      return next;
   }

   public Object getData()
   {
      return data;
   }

   public void setPrev(Node _prev)
   {
      prev = _prev;
   }

   public void getPrev(Node _next)
   {
      next = _next;
   }

   public void setData(Object _data)
   {
      data = _data;
   }
}
