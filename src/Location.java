/**
 ����� �������� �� ���������� ����� ������.
 ���������� �������������, �������������.
 **/
public class Location
{
    /** X  **/
    public int xCoord;

    /** Y  **/
    public int yCoord;


    /** ����������� � �����������. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** ����������� ��� ����������, ������ �������� 0 0 **/
    public Location(){  this(0, 0);   }
    
    /** ����� �������� ���� ����� �� ��������� **/
    public boolean equals(Object obj) {
        
        // ���������� ������ ������ Object �������� ����������� ������ Location
        if (obj instanceof Location) {
            
            // ���������� �� ������ Object � ������ Location,
            Location other = (Location) obj;
            // �������� ��������� ���������. ���� ���������� �����, ���������� True ����� False
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        return false;
    }

    /** ��������� ���-���� �������. **/
    public int hashCode() {
        int result = 17; // ����� ��������� ������� �����
        
        // ���������� ������ ������� ����� ��� ��������� � ���������� ����������
        result = 37 * result + xCoord;
        result = 37 * result + yCoord;
        return result;
    }
}
