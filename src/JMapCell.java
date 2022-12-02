import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * ��� SWING - ���������, ������� ������������ ��� ����������� ��������� ����� �� �����
 * ���� ����� ������������ ��� ���������������� Swing ��������� ��� ������������� �����
 * ����� � 2D ����. ������ ����� ��������� ���������, �������� - �������� �� ������ ����������
 * ��� ���. ����������� �� JComponent
 */
public class JMapCell extends JComponent
{
    //������������� ������� ������ �� ������, � ����� ������ ��� 12x12 ��������
    private static final Dimension CELL_SIZE = new Dimension(12, 12);

    /** �������� true �������, ��� ������ �������� ������� ��� ������� **/
    boolean endpoint = false;
    
    
    /** �������� true ��������� ������������ �����, false � �������������� **/
    boolean passable = true;
    
    /**
     * �������� true ��������� �� ��, �������� �� ������ ������ ����� ������� � ������
     **/
    boolean path = false;

    /**
     * ����������� ������� ����� ����� ����� � ������������� "�������������, ������������
     * � ������ �������� ������������.
     **/
    public JMapCell(boolean pass)
    {
        // ������������� ������ ������
        setPreferredSize(CELL_SIZE);

        setPassable(pass);
    }
    
    /** ����������� ������� ����� ����� ����� �� �������� ������������ �� ���������(True). **/
    public JMapCell()
    {
        this(true);
    }
    
    /** �������� ��� ������ ��� ��������� ��� ��������. **/
    public void setEndpoint(boolean end)
    {
        endpoint = end;
        updateAppearance();
    }
    
    /**
     * ��������� ������������ ������.
     * ����� ��������� ������������ ����������� ���� ������ � ������� ��� �������
     **/
    public void setPassable(boolean pass)
    {
        passable = pass;
        updateAppearance();
    }
    
    /** �������� ������������ **/
    public boolean isPassable()
    {
        return passable;
    }
    
    /** ������������ ������������ �� ����������������� �������� **/
    public void togglePassable()
    {
        setPassable(!isPassable());
    }
    
    /**
     * �������� ������ ��� ����� ���� A* ���������
     * ����� ��������� ���� ����������� ���� ������ � �������
     * **/
    public void setPath(boolean path)
    {
        this.path = path;
        updateAppearance();
    }
    
    /**
     * ���������������� ����� ��������� �������� ����� ����� �� ������ � ���������
     **/
    private void updateAppearance()
    {
        if (passable)
        {
            setBackground(Color.WHITE);
            if (endpoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.GREEN);
        }
        else
        {
            setBackground(Color.RED);
        }
    }

    /**
     * ���������� ������ ��������� ������ � � �����.
     **/
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
