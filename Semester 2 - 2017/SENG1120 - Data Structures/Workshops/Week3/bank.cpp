// This program creates an instance of a simple account object and
// performs some operations on it
// Programmer:  Dr Frans Henskens
// Last Modified:  28 July 2006

#include <iostream>
#include <cstdlib>
#include "account.h"

using namespace std;

int main()
{
    cout << "Creating first account" << endl;
    account my_account1;
    cout << "Initial Balance is " << my_account1.balance() << endl;
    cout << "Adding an initial amount of 10" << endl;
    my_account1.deposit(10);
    if (my_account1.has_funds())
    {
        cout << "Balance is "
              << my_account1.balance()
              << endl;
        cout << "Deposit 100" << endl;
        my_account1.deposit(100);
        cout << "Balance is "
              << my_account1.balance()
              << endl;
        cout << "Withdraw 75" << endl;
        my_account1.withdraw(75);
        cout << "Balance is "
              << my_account1.balance()
              << endl;
    }
    else
        cout << "Account is empty" << endl;
    cout << "Creating second account" << endl;
    account my_account2;
    if (my_account2.has_funds())
    {
        cout << "Balance is "
              << my_account2.balance()
              << endl;
        cout << "Deposit 100" << endl;
        my_account2.deposit(100);
        cout << "Balance is "
              << my_account2.balance()
              << endl;
        cout << "Withdraw 75" << endl;
        my_account2.withdraw(75);
        cout << "Balance is "
              << my_account2.balance()
              << endl;
    }
    else
        cout << "Account is empty" << endl;
    return EXIT_SUCCESS;
}
