public class myClass
{
    public static void main(String[] args)
    {
        int a = 1;
    }

    public int checkbool(int x, boolean a, boolean b)
    {
        if(a)
            x++;
        if(b)
            x--;
        return x;
    }

    public static int median(int x, int y, int z){
        int median = 0;
        if(x >= y && x <= z){ // y<=x<=z
            median = x;
        } else if(x >= z && x <= y){ // z<=x<=y
            median = x;
        } else if(y >=x && y < z){ // x<=y<=z
            median = y;
        } else if(y >= z && y <= x){ // z<=y<=x
            median = y;
        } else { // x<=z<=y or y<=z<=x
            median = z;
        }
        return median;
    }
}