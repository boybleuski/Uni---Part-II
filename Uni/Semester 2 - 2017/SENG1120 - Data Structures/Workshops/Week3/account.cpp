// Programmer:  Dr Frans Henskens
// Last modified:  28 July 2006

#include "account.h"

account::account(int initialValue)
{
    acct_balance = initialValue;
}

void account::deposit(int amount)
{
    acct_balance += amount;
}

void account::withdraw(int amount)
{
    acct_balance -= amount;
}

int account::balance() const
{
    return acct_balance;
}

bool account::has_funds() const
{
   return (acct_balance > 0.0);
}
