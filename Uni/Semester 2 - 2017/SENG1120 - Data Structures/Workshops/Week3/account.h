// This defines a class that implements a simple
// account object for whole numbers of dollars, pounds, or whatefer
// currency is used.
// Programmer:  Dr Frans Henskens
// Last modified:  28 July 2006

class account
{
public:
    // Members that are externally visible

    // These are member functions

    // Constructor

    // Precondition
    // Postcondition:  A new instance of account is created 
    // and its instance data initialsed to either zero or a 
    // parameter-provided value
    account(int initialValue);

    // Members that mutate data

    // Precondition:  acct_balance has been initialised
    // Postcondition:  amount is added to the acct_balance
    void deposit(int amount);

    // Precondition:  acct_balance has been initialised
    // Postcondition:  amount is subtracted from the acct_balance
    void withdraw(int amount);

    // Members that query data

    // Precondition:  acct_balance has been initialised
    // Postcondition:  The value of acct_balance is returned
    int balance() const;

    // Precondition:  acct_balance has been initialised
    // Postcondition:  Returns true if acct_balance is greater 
    //                 than zero, false otherwise
    bool has_funds() const;

private:

    int acct_balance;
};
