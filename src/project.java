import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
<applet code="project" height=430 width=500>
</applet>
*/
public class project extends Applet implements Runnable,MouseListener,ActionListener,ItemListener
{
	int i=31,tot_val=100,temp=0,qno=1,countans=0;
        int[] bat=new int[4];
	Frame sf=new sampleFrame("Project");
	String timer;
        String[][] choices=new String[5][];
        String[] answers=new String[5];
        String[] questions=new String[5];
	Frame nf1;
	Thread t;
	Color c;
	Label l1,l2,l3,l4;
	Checkbox[] cb;
        Font f1,f2;
        Button b10,b11,b12,b13;
        Button[] b;
	int count=0,nr_of_ques=10;
	TextField tf1,tf2,tf3,tf4,tf5;
        public project()
        {
            for(int k=0;k<5;k++)
                choices[k]=new String[4];
        }
        @Override
	public void init()
	{
            questions[0]="Q:- Which is the hardest element?";answers[0]="Diamond";
            questions[1]="Q:- Which is our national animal?";answers[1]="Tiger";
            questions[2]="Q:- Who is the father of computers?";answers[2]="Charles Babbage";
            questions[3]="Q:- Who is the founder of intel?";answers[3]="Gordan Moore";
            questions[4]="Q:- Who is the founder of C language?";answers[4]="Dennis Ritchie";
            cb=new Checkbox[4];
                choices[0][0]="Diamond";choices[0][1]="Ruby";choices[0][2]="Manganese";choices[0][3]="Iron";
                choices[1][0]="Dog";choices[1][1]="Lion";choices[1][2]="Tiger";choices[1][3]="Monkey";
                choices[2][0]="Mark Zuckerberg";choices[2][1]="Charles Babbage";choices[2][2]="Larry Page";choices[2][3]="Biz Stone";
                choices[3][0]="Gordan Moore";choices[3][1]="Curtis Priem";choices[3][2]="Jim Giles";choices[3][3]="David Packard";
                choices[4][0]="James Arthur";choices[4][1]="Dennis Ritchie";choices[4][2]="Brendan Eich";choices[4][3]="Tim Burner";
                b=new Button[10];
		nf1=new Frame("Dialog Box");
		l1=new Label(questions[0]);
		l2=new Label("THANK YOU!!!!!!!!!");
		l3=new Label("Correct Answer");l3.setBounds(150,200,100,100);
                
		nf1.setLayout(null);setLayout(null);
                l2.setFont(f2);
		l2.setBounds(150,150,100,100);
		nf1.add(l2);
		nf1.setSize(400,400);
                for(int k=0;k<10;k++)
                    b[k]=new Button("10 Lakhs");
                b10=new Button("START");b10.setBounds(50,385,90,40);b10.addActionListener(this);add(b10);
		b11=new Button("SUBMIT");b11.setBounds(170,385,90,40);b11.addActionListener(this);
		b12=new Button("EXIT");b12.setBounds(290,385,90,40);b12.addActionListener(this);
		b13=new Button("CLOSE"); b13.setBounds(160,300,70,30); nf1.add(b13); b13.addActionListener(this);
                f1=new Font("Arial",Font.BOLD,20);
                f2=new Font("Arial",Font.BOLD,25);
		c=new Color(0.2f,0.2f,0.5f);
		setBackground(c);
                t=new Thread(this);
		sf.setSize(500,500);
		sf.setVisible(true);
		setLayout(null);
                l1.setFont(f2);
		l1.setBounds(60,30,400,30);
		b[0].setBounds(50,300,70,30);b[1].setBounds(50,340,70,30);b[2].setBounds(130,300,70,30);b[3].setBounds(130,340,70,30);b[4].setBounds(210,300,70,30);b[5].setBounds(210,340,70,30);b[6].setBounds(290,300,70,30);b[7].setBounds(290,340,70,30);b[8].setBounds(370,300,70,30);b[9].setBounds(370,340,70,30);
		addMouseListener(this);
		t.start();
		tf1=new TextField(9);
		tf2=new TextField(9);
		tf3=new TextField(9);
		tf4=new TextField(9);
		tf5=new TextField(9);
		tf1.setEditable(false);tf2.setEditable(false);tf3.setEditable(false);tf4.setEditable(false);tf5.setEditable(false);
		tf1.setText(Integer.toString(bat[0])+" Lakhs");
		tf2.setText(Integer.toString(bat[1])+" Lakhs");
		tf3.setText(Integer.toString(bat[2])+" Lakhs");
		tf4.setText(Integer.toString(bat[3])+" Lakhs");
		tf5.setText(Integer.toString(tot_val)+" Lakhs");
		tf1.setBounds(90,120,63,20);tf2.setBounds(330,120,63,20);tf3.setBounds(90,190,63,20);tf4.setBounds(330,190,63,20);tf5.setBounds(210,235,65,25);
		add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);
		add(l1);addcheckbox(0);
                
                for(int k=0;k<10;k++)
                add(b[k]);add(b11);add(b12);
	}
        public void addcheckbox(int count)
        {
            setLayout(null);
            for(int k=0;k<4;k++)
             cb[k]=new Checkbox(choices[count][k]);
            cb[0].setBounds(90,80,150,50);
            cb[1].setBounds(330,80,150,50);
            cb[2].setBounds(90,150,150,50);
            cb[3].setBounds(330,150,150,50);
            for(int k=0;k<4;k++)
            {
                add(cb[k]);
                cb[k].addItemListener(this);
            }                		
        }
        public void addans(int countans)
        {
            l4=new Label(answers[countans]);
            l4.setFont(f1);
          //  l4.setColor(Color.green);
            l4.setBounds(140,485,170,40);
            add(l4);
        }
        @Override
	public void mouseClicked(MouseEvent me)
	{
	}
        @Override
	public void mouseEntered(MouseEvent me)
	{
	}
        @Override
	public void mouseExited(MouseEvent me)
	{
	}
        @Override
	public void mousePressed(MouseEvent me)
	{
	}
        @Override
	public void mouseReleased(MouseEvent me)
	{
		if(count>0 && count<2)
		{
		if(me.getX()>90 && me.getX()<170 && me.getY()>120 &&me.getY()<140 && tot_val>0)
		{bat[0]+=10;tot_val-=10;
		tf1.setText(Integer.toString(bat[0])+" Lakhs");
		tf5.setText(Integer.toString(tot_val)+" Lakhs");
		showStatus("You Dropped Money Into First Answer");
         }
		else if(me.getX()>330 && me.getX()<393 && me.getY()>120 &&me.getY()<140 && tot_val>0)
		{bat[1]+=10;
		tot_val-=10;
		tf2.setText(Integer.toString(bat[1])+" Lakhs");
		tf5.setText(Integer.toString(tot_val)+" Lakhs");
		showStatus("You Dropped Money Into Second Answer");
		}
		else if(me.getX()>90 && me.getX()<173 && me.getY()>190 &&me.getY()<210 && tot_val>0)
		{bat[2]+=10;
		tot_val-=10;
		tf3.setText(Integer.toString(bat[2])+" Lakhs");
		tf5.setText(Integer.toString(tot_val)+" Lakhs");
		showStatus("You Dropped Money Into Third Answer");
		}
		else if(me.getX()>330 && me.getX()<393 && me.getY()>190 &&me.getY()<210 && tot_val>0)
		{bat[3]+=10;
		tot_val-=10;
		tf4.setText(Integer.toString(bat[3])+" Lakhs");
		tf5.setText(Integer.toString(tot_val)+" Lakhs");
		showStatus("You Dropped Money Into Fourth Answer");
		}
		}
	}
        @Override
	public void run()
	{
            while(true)
		{
                    try{
			repaint();
			Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                }
	}
        @Override		
	public void paint(Graphics g)
	{
		
                g.setFont(f1);
		if(i>0 && i<=30)
		{g.drawRect(425,380,65,30);
                    if(i==0)
		{
			i=1;
		
		timer="00::0"+i;
		}
		else if(i<10)
		timer="00::0"+i;
			else
			timer="00::"+i;
			i--;
		g.drawString(timer,430,400);
		}
		else if(i==0)
		nf1.setVisible(true);
	}
        @Override
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
            switch(s)
				{
					case "START":if(count==0)
                                                    {
                                                        
                                                        i=30;
                                                        count=1;
                                                    }
                                                        break;
					case "CLOSE": 
                                            i=32;count=2;
                                            for(int k=0;k<4;k++)
                                                bat[k]=0;
                                            tf1.setText(Integer.toString(bat[0])+" Lakhs");
                                            tf2.setText(Integer.toString(bat[1])+" Lakhs");tf3.setText(Integer.toString(bat[2])+" Lakhs");
                                            tf4.setText(Integer.toString(bat[3])+" Lakhs");                                            
                                            
                                            for(int k=0;k<4;k++)
                                            {
                                                cb[k].setState(false);
                                                remove(cb[k]);
                                            }
                                            try
                                            {
                                                if(countans>0)
                                                remove(l4);
                                                addcheckbox(qno);
                                            }
                                            catch(ArrayIndexOutOfBoundsException adddd)
                                            {
                                                setForeground(Color.green);
                                                addans(countans);
                                            countans++;
                                                try{
                                                    Thread.sleep(300);
                                                }
                                                catch(InterruptedException sss){}
                                                System.exit(0);
                                            }
                                            remove(l1);
                                            setForeground(Color.green);
                                            addans(countans);
                                            countans++;
                                            setForeground(Color.black);
                                            
                                            if(qno<5)
                                            {
                                                l1=new Label(questions[qno]);
                                                l1.setFont(f2);
                                                l1.setBounds(60,30,500,30);add(l1);
                                            }											
                                            else
                                                System.exit(0);
                                            qno++;
                                            count=0;
                                            nf1.setVisible(false);
                                            
                                            
                                            break;
                                        case "SUBMIT":
                                            i=32;count=2;
                                            tot_val=temp;
                                            tf5.setText(Integer.toString(tot_val)+" Lakhs");
                                            nf1.setVisible(true);
                                            break;
                                        case "EXIT":System.exit(0);
                                                    break;
				}
	}
        @Override
        public void itemStateChanged(ItemEvent ie)
        {
            for(int p=0;p<5;p++)
            {
             for(int k=0;k<4;k++)
             {
                 if(cb[k].getLabel().equals(answers[p]) && cb[k].getState()==true)
                 {
                     temp=bat[k];
                 }
                 else if(cb[k].getLabel().equals(answers[p]) && cb[k].getState()==false)
                 {
                     temp=0;
                 }
             }
            }
        }
        
}
class sampleFrame extends Frame implements ActionListener,AdjustmentListener,WindowListener
{
	String msg,ID=" ",DOB,Course,Batch_Year,hobbies,birth_place,contact;
	int x;
	public sampleFrame(String name)
	{
                
		super(name);
		MenuBar m=new MenuBar();
		setMenuBar(m);
		Menu m1=new Menu("Student Information");
		Menu m2=new Menu("Project Details");
		Menu m3=new Menu("Application");
		MenuItem mi1,mi2,mi3,mii1,mii2,mii3,mii4,miii1;
		mi1=new MenuItem("Gaurav Rustagi");m1.add(mi1);
		mi2=new MenuItem("Shubham Gupta");m1.add(mi2);
		mi3=new MenuItem("Sankalp Jain");m1.add(mi3);
                mii1=new MenuItem("Project Title");m2.add(mii1);
                mii2=new MenuItem("Description");m2.add(mii2);
                mii3=new MenuItem("Technologies Used");m2.add(mii3);
                mii4=new MenuItem("Nr Of People Involved");m2.add(mii4);
                miii1=new MenuItem("Play Game");m3.add(miii1);
              
		m.add(m1);
		m.add(m2);
		m.add(m3);
		m3.addActionListener(this);
		mi1.addActionListener(this);mi2.addActionListener(this);mi3.addActionListener(this);
                mii1.addActionListener(this);mii2.addActionListener(this);mii3.addActionListener(this);mii4.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		Scrollbar s1=new Scrollbar(Scrollbar.VERTICAL);
		s1.setBounds(475,50,15,435);
		add(s1);
		s1.addAdjustmentListener(this);
	}
        @Override
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
            switch(s) 
			{
                case "Gaurav Rustagi":
                    msg="Gaurav Rustagi";
                    ID="12BIT0082";
                    DOB="08-12-1994";
                    Course="B.TECH";
                    Batch_Year="2012-2016";
                    break;
                case "Shubham Gupta":
                    msg="Shubham Gupta";
                    ID="12BIT0139";
                    DOB="09-11-1993";
                    Course="B.TECH";
                    Batch_Year="2012-2016";
                    break;
                case "Sankalp Jain":
                    msg="Sankalp Jain";
                    ID="12BIT0226";
                    DOB="13-04-1994";
                    Course="B.TECH";
                    Batch_Year="2012-2016";
                    break;
                case "Project Title":
                    msg="Online Gaming 1";
                    ID=" ";
                    break;
                case "Description":
                    msg="Game is to bet the money on the option of a question given and drag the money button";
                    ID=" ";
                    break;
                case "Technologies Used":
                    msg="Applet,Event Handling,Frames,MenuBar class,ActionListener Interface";
                    ID=" ";
                    break;
                case "Nr Of People Involved":
                    msg="Three";
                    ID=" ";
                    break;
                case "Play Game":
                    setVisible(false);
                    break;
            }
			repaint();
	}
        @Override
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		x=ae.getValue();
		repaint();
	}
        @Override
	public void windowClosed(WindowEvent w){}
        @Override
	public void windowIconified(WindowEvent w){}
	@Override
	public void windowDeiconified(WindowEvent w){}
	@Override
	public void windowClosing(WindowEvent w)
	{
		setVisible(false);
	}
        @Override
	public void windowActivated(WindowEvent w){}
        @Override
	public void windowDeactivated(WindowEvent w){}
        @Override
	public void windowOpened(WindowEvent w){}
        @Override
	public void paint(Graphics g)
	{
		if(ID.length()>1)
		{
			g.drawRect(40,175-x,200,175);
                        g.setColor(Color.green);
			g.drawString(msg,50,200-x);
                        g.setColor(Color.black);
			g.drawString(ID,50,230-x);
			g.drawString(DOB,50,260-x);
			g.drawString(Course,50,290-x);
			g.drawString(Batch_Year,50,320-x);
		}
		else
		try
                {
                 g.drawString(msg,50,200-x);
                }
                catch(NullPointerException e){}
	}
}