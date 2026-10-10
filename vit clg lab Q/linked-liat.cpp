struct node{
    int data;
    struct node*next;
}*newnode,*head,*tail,*temp;

void insertAtEnd(int elem){
    newnode=(struct node*)malloc(sizeof(struct node));
    newnode->data=elem;
    newnode->next=NULL;
    if(head==NULL)
    {
        head=newnode;
        tail=newnode;
    }
    else
    {
        tail->next=newnode;
        tail=newnode;
    }
}

void display()
{
    if(head==NULL)
    {
        cout<<"Linked List is empty"<<endl;
    }
    else
    {
        cout<<"Linked list elements="<<endl;
        for(temp=head;temp!=NULL;temp=temp->next)
        {
            cout<<temp->data<<endl;
        }
    }
}
void insertBegin(int elem)
{
    newnode=(struct node*)malloc(sizeof(struct node));
    newnode->data=elem;
    newnode->next=NULL;
    if(head==NULL)
    {
        head=newnode;
        tail=newnode;
    }
    else
    {
        newnode->next=head;
        head=newnode;
    }
}

int main(){
    insertAtEnd(6);
    display();
    insertAtEnd(7);
    display();
    insertAtEnd(3);
    display();
    insertAtEnd(5);
    display();
    insertBegin(1);
    display();
    
    
}

