import java.util.*;

class HistoryNode{
    String url;
    HistoryNode prev;
    HistoryNode next;
    HistoryNode(String url){
        this.url=url;
        this.prev=null;
        this.next=null;
    }
}

class BrowserTab{
    HistoryNode head=null;
    HistoryNode current=null;

    void visit(String url){
        HistoryNode newNode=new HistoryNode(url);
        if(head==null){
            head=newNode;
            current=newNode;
        }else{
            current.next=null;
            newNode.prev=current;
            current.next=newNode;
            current=newNode;
        }
        System.out.println("Visited: "+url);
    }

    void back(){
        if(current!=null && current.prev!=null){
            current=current.prev;
            System.out.println("Back to: "+current.url);
        }else{
            System.out.println("No back history");
        }
    }

    void forward(){
        if(current!=null && current.next!=null){
            current=current.next;
            System.out.println("Forward to: "+current.url);
        }else{
            System.out.println("No forward history");
        }
    }

    void showHistory(){
        HistoryNode temp=head;
        while(temp!=null){
            if(temp==current) System.out.print("["+temp.url+"] ");
            else System.out.print(temp.url+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

public class BrowserHistoryManager{
    static Stack<BrowserTab> closedTabs=new Stack<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BrowserTab currentTab=new BrowserTab();

        while(true){
            System.out.println("1.Visit 2.Back 3.Forward 4.Close Tab 5.Reopen Tab 6.History 7.Exit");
            int ch=sc.nextInt();

            if(ch==1){
                System.out.print("Enter URL: ");
                currentTab.visit(sc.next());
            }
            else if(ch==2){
                currentTab.back();
            }
            else if(ch==3){
                currentTab.forward();
            }
            else if(ch==4){
                closedTabs.push(currentTab);
                currentTab=new BrowserTab();
                System.out.println("Tab closed. New tab opened.");
            }
            else if(ch==5){
                if(closedTabs.isEmpty()){
                    System.out.println("No closed tabs to restore");
                }else{
                    currentTab=closedTabs.pop();
                    System.out.println("Recently closed tab restored");
                }
            }
            else if(ch==6){
                currentTab.showHistory();
            }
            else{
                break;
            }
        }
    }
}
