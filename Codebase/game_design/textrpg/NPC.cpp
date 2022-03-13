#include <cstdlib>
#include <iostream>
#include <string>
#include <random>
#include "NPC.h"

using namespace std;

NPC::NPC(string n_type, string n_sex, int n_age)
{
  type = n_type;
  sex = n_sex;
  age = n_age;
  randomise();
}

NPC::NPC(string n_type, string n_name, string n_sex, string n_job, int n_age)
{
  type = n_type;
  sex = n_sex;
  job = n_job;
  age = n_age;
  name = n_name;
  randomise();
}

void NPC::randomise()
{
  random_device device;
  mt19937 generator(device());

  if (hair == "")
  {
    uniform_int_distribution<int> distribution(1,4);
    int seed = distribution(generator);
    hair = chooseHair(type, sex, age, seed);
  }

  if (skin == "")
  {
    uniform_int_distribution<int> distribution(1,5);
    int seed = distribution(generator);
    skin = chooseSkin(type, sex, age, seed);
  }

  if (appearance == "")
  {
    appearance = chooseAppearance(type, sex, age);
  }

  if (bodyType == "")
  {
    uniform_int_distribution<int> distribution(1,4);
    int seed = distribution(generator);
    bodyType = chooseBodyType(type, sex, age, seed);
  }

  if (height == 0)
  {
    bodyType = chooseHeight(type, sex, age);
  }

  if (personality == "")
  {
    uniform_int_distribution<int> distribution(1,4);
    int seed = distribution(generator);
    personality = choosePersonality(type, sex, age, seed);
  }

  if (job == "")
  {
    uniform_int_distribution<int> distribution(1,4);
    int seed = distribution(generator);
    job = chooseJob(type, sex, age, seed);
  }
}

void NPC::specific(string n_type, string n_name, string n_sex, string n_job, string n_hair, string n_skin, string n_appearance, string n_bodyType, string n_personality, int n_age)
{
  type = "Unique";
  name = n_name;
  sex = n_sex;
  job = n_job;
  hair = n_hair;
  skin = n_skin;
  appearance = n_appearance;
  bodyType = n_bodyType;
  personality = n_personality;
  age = n_age;
}

void NPC::describe()
{
  cout << endl << "Name: " << name << endl;
  cout << "Type: " << type << endl;
  cout << "Job: " << job << endl;
  cout << "Sex: " << sex << endl;
  cout << "Age: " << age << endl;
  cout << "Body Type: " << bodyType << endl;
  cout << "Hair: " << hair << endl;
  cout << "Skin: " << skin << endl;
  cout << "Appearance: " << appearance << endl;
  cout << "Personality: " << personality << endl;
}

string NPC::chooseHair(string type, string sex, int age, int seed)
{
  string hair[6] = {"blonde", "black", "brown", "grey", "white", "red"};
  return hair[seed];
}

string NPC::chooseSkin(string type, string sex, int age, int seed)
{
  string skin[5] = {"pallid", "fair", "olive", "brown", "black"};
  return skin[seed];
}

string NPC::chooseAppearance(string type, string sex, int age)
{
  random_device device;
  mt19937 generator(device());
  int seed = 0;

  if (sex == "male")
  {
    uniform_int_distribution<int> distribution(1,7);
    seed = distribution(generator);
    string appearanceA[7] = {"handsome", "sexy", "pretty", "average", "ugly", "deformed", "neckbeard"};
    appearance = appearance[seed];
  }
  else if (sex == "female")
  {
    uniform_int_distribution<int> distribution(1,7);
    seed = distribution(generator);
    string appearanceA[7] = {"stunning", "sensual", "cute", "average", "ugly", "hideous", "eldritch"};
    appearance = appearance[seed];
  }
  else
  {
    uniform_int_distribution<int> distribution(1,4);
    seed = distribution(generator);
    string appearanceA[4] = {"scary", "beautiful", "normal", "disgusting"};
    appearance = appearance[seed];
  }

  return appearance;
}

string NPC::chooseBodyType(string type, string sex, int age, int seed)
{
  string bodyType[7] = {"underweight", "slender", "average", "chubby", "obese", "toned", "muscular"};
  return bodyType[seed];
}

int NPC::chooseHeight(string type, string sex, int age)
{
  random_device device;
  mt19937 generator(device());

  if (type.find("human") == true)
  {
    if (age < 5)
    {
      uniform_int_distribution<int> distribution(50,90);
      height = distribution(generator);
    }

    else if (age < 12)
    {
      uniform_int_distribution<int> distribution(80,120);
      height = distribution(generator);
    }

    else if (age < 18)
    {
      uniform_int_distribution<int> distribution(120,170);
      height = distribution(generator);
    }

    else if (age < 60)
    {
      uniform_int_distribution<int> distribution(150,200);
      height = distribution(generator);
    }

    else
    {
      uniform_int_distribution<int> distribution(140,190);
      height = distribution(generator);
    }
  }

  else if (type.find("dragon") == true)
  {
    uniform_int_distribution<int> distribution(600,750);
    height = distribution(generator);
  }

  else if ((type.find("kangaroo") || type.find("bear") || type.find("cow")) == true)
  {
    uniform_int_distribution<int> distribution(180,210);
    height = distribution(generator);
  }

  else if ((type.find("dog") || type.find("wolf") || type.find("biginsect")) == true)
  {
    uniform_int_distribution<int> distribution(80,120);
    height = distribution(generator);
  }

  else if ((type.find("cat") || type.find("fox") || type.find("chicken") || type.find("insectswarm")) == true)
  {
    uniform_int_distribution<int> distribution(40,60);
    height = distribution(generator);
  }

  else if ((type.find("rabbit") || type.find("rat") || type.find("pigeon")) == true)
  {
    uniform_int_distribution<int> distribution(20,40);
    height = distribution(generator);
  }

  return height;
}

string NPC::choosePersonality(string type, string sex, int age, int seed)
{
  string personalityChoice[4] = {"angry", "funny", "happy", "morose"};
  personality = personalityChoice[seed];
  return personality;
}

string NPC::chooseName(string type, string sex, int age, int seed)
{
  string nameChoice[4] = {"blonde", "black", "grey", "red"};
  name = nameChoice[seed];
  return name;
}

string NPC::chooseJob(string type, string sex, int age, int seed)
{
  string jobChoice[4] = {"blonde", "black", "grey", "red"};
  job = jobChoice[seed];
  return job;
}
