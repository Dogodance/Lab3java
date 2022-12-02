/**
 * ����� ������ ���� � ��������������� ����
 * ����� ������������ ��������� ��� � ���� ��������������� ���������� A*
 * ����� ������� �� �������, ���������� ������ ���� � ��������� ����������
 * ��� ����������� ������� ����
 **/
public class Waypoint
{
    /** ������� �����. **/
    Location loc;

    /**
     * ���������� ����� ����, ��� <code>null</code> ���� ��� ������ ����
     **/
    Waypoint prevWaypoint;

    /**
     * ���� ������ ����� ���������� ���������� ��������� ���������� � ���������
     * �������, �� ���� ����� ���������� ����� ������� �����. ��� ����������� ���������
     * ���� ��� ��������������� � ������.
     **/
    private float prevCost;

    /**
     * ���� ������ ���������� ��������� ����������� �� ������� ����� �� ���������.
     **/
    private float remainingCost;


    /**
     * ����������� ��� ����� ����� � ������������ ��������. ���������� �����
     * ����� ���� ����������� ���������� ��� ����� ���� <code>null</code>, ���
     * ����� ����������, ��� ����� �������� ������� ����.
     **/
    public Waypoint(Location loc, Waypoint prevWaypoint)
    {
        this.loc = loc;
        this.prevWaypoint = prevWaypoint;
    }


    /** ������� ������� ����� **/
    public Location getLocation()
    {
        return loc;
    }
    
    /**
     * ������� ���������� �����, ����� ���� <code>null</code> ���� ��� ����� ����
     **/
    public Waypoint getPrevious()
    {
        return prevWaypoint;
    }
    
    /**
     * ������ ������� ������������� ���������� ��������� � ���������� ���������
     * ���� � ����� ������.
     **/
    public void setCosts(float prevCost, float remainingCost)
    {
        this.prevCost = prevCost;
        this.remainingCost = remainingCost;
    }

    /**
     * ���������� ������� ��������� ����������� ���� �� ������ �� ������� �����
     **/
    public float getPreviousCost()
    {
        return prevCost;
    }

    /**
     * ���������� ���������� ��������� ���� �� ������� ����� �� �����
     **/
    public float getRemainingCost()
    {
        return remainingCost;
    }

    /**
     * ���������� ����� ��������� ����� ���� ��� ������� �����. �������� � ���� �����
     * ��������� �� ������ �� ������� �����, � ����� ��������� �� ������� ����� ��
     * �����.
     **/
    public float getTotalCost()
    {
        return prevCost + remainingCost;
    }
}

