// Assignment 1 - SENG1120
// Student No.: 	c3130069
// Name: 			Sam Dolbel
// Tutorial: 		10-12pm Monday
// Created: 		28 August 2017
// Last modified: 3 September 2017

#include <cstdlib>

#ifndef LINKED_LIST
#define LINKED_LIST
using namespace std;

class Node
{
   friend class LinkedList;
   private:
      typedef string data;
      data word;
	  Node *prev;
	  Node *next;
   
   public:
      // Constructors
	  // Precondition: None
	  // Postcondition: New instance of the Node class
	  Node(const data& word = data(), Node* next = NULL);
	  
	  // Mutators
	  
	  // Queriers
	  
};

#endif