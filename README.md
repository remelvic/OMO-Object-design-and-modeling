<h1 align="Center">Semester work(Smart Home)</h1>

## Topic:
intelligent house simulation, where we simulate the operation of the household,
use individual equipment of the house and evaluate the use, consumption, free
and working time of individual persons

## By what principle does everything work:
The main class is launched, which creates a simulation with the configuration chosen by the user. A whole year passes and reports are generated in one text file.

## Design patterns:
  * We use the **State Machine** design pattern for the microwave which is located in package stuff -> usable -> microwave
  * The **Singleton** design pattern is in the Home class
  * The **chain of responsibility** design pattern is located in package actions -> repair. Used to fix stuff in the house.
  * The design pattern **builder** is used to build reports, adds a person who participated in an action, the time at which something happened, and so on. Found in package report
  * The **Observer** design pattern is used to generate an action or change in the house and send a request to create a report. Uses the ActionSubscribers classes and the Publisher, Subscriber interfaces.

## Names of participants:
Victor Remel, Roman Bulavkin

## Platforms used:
Gitlab: https://gitlab.fel.cvut.cz/remelvic/smart_home

Lucide.app: https://lucid.app/documents#/dashboard

Java **SDK 17**

<h1 align="Center">For the Developers</h1>

The project consists of 4 packages: 
1) **Home** The package consists of the **rooms** package, which contains 
   the room classes, from the ***Floor*** and ***Home*** classes
   ###Classes used:
   * **Floor** _(The class contains which rooms are present on the floor.)_
     * function `public ArrayList<Room> getRoomList()` Normal getter

   * **Home** _(The Home class is the main class in which the whole process takes place.)_
     * function `public synchronized static Home getInstance(int config)` The method is needed to use the Singleton pattern.
     * function `public ArrayList<Inhabitant> getInhabitantList()` Normal getter
     * function `public void chooseInhabitants(int time)` The method determines which of the inhabitants of the house at what time will be in any room.
     * function `public ArrayList<Stuff> getStuffList()` Normal getter   
     * function `public Kitchen getKitchen()` Normal getter
   
   * **The room package contains : Bathroom, Bedroom, Garage, Kitchen, LivingRoom, (abstract)Room**
     * **Bathroom** _(The class contains electrical appliances and things that are in the bedroom.)_
       * function `public String toString()` The method returns a string that will be sent to the report
     * **Bedroom** _(The class contains electrical appliances and things that are in the bedroom.)_
       * function `public String toString()` The method returns a string that will be sent to the report
     * **Garage** _(The class contains electrical appliances and things that are in the garage.)_
       * function `public String toString()` The method returns a string that will be sent to the report
     * **Kitchen** _(The class contains electrical appliances and things that are in the Kitchen.)_
       * function `public String toString()` The method returns a string that will be sent to the report
     * **LivingRoom** _(The class contains electrical appliances and things that are in the living room.)_
       * function `public String toString()` The method returns a string that will be sent to the report
     * **Room** _(An abstract class contains basic methods for all rooms in the house.)_
       * function `public ArrayList<Pet> getPetList()` Normal getter
       * function `public ArrayList<Person> getPersonList()` Normal getter 
       * function `public void setPersonList(ArrayList<Person> personList)` Normal setter
       * function `public void setPetList(ArrayList<Pet> petList)` Normal setter
       * function `public void updateInhabitantList(ArrayList<Inhabitant> inhabitantList)` The method updates the list of residents of the house who are on the given floor.
       * function `public void addInhabitant(Inhabitant inhabitant)` The method will add one resident to the general list of residents.
       * function `public void removeInhabitant(Inhabitant inhabitant)` The method will remove one inhabitant from the general list of residents.
       * function `public void setFloorNum(int floorNum)` The method will set the current floor number.
       * function `public int getFloorNum()` Normal getter
       * function `public ArrayList<Stuff> getStuffList()` Normal getter
       * function `public void addStuff(Stuff stuff)` This method adds stuff to the list of all stuff in the room.
       * function `public abstract void configure()` The method will add all the necessary sensors and elements to the room.


2) **Inmates** The package consists of the **animals** packages, 
   which contains the animal classes and the **peoples** package, which contains
   the classes of the inhabitants of the house.
    ###Classes used:
    * **The animals package contains : Cat, Dog, Parrot, (abstract)Pet, (enum)PetType** 
      * **Cat** _(The class contains methods related to the cat.)_
      * **Dog** _(The class contains methods related to the dog.)_
      * **Parrot** _(The class contains methods related to the parrot.)_
      * **Pet** _(An abstract class contains basic methods for all rooms in the house.)_
        * function `public int getAge()` Normal getter
        * function `public String getName()` Normal getter
        * function `public abstract void eat()`When the method are called, the amount of satiety of the animal increases.
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **PetType** _(the enum type is used to define the type of animals.)_
        * function `public abstract String toString()` return a string of the type of pet depending on who is calling it.
        
    * **The Peoples package contains: Baby, Child, Courier, Dad, Grandpa, Grandma, Mom, (abstract)Person, (enum)PersonType, RepairServiceMaster**:
      * **Baby** _(The class contains methods related to the baby.)_
      * **Child** _(The class contains methods related to the child.)_
      * **Courier** _(The class is needed for a courier who will replenish food in the refrigerator.)_
      * **Dad** _(The class contains methods related to the dad.)_
        * function `public Repair fix(Stuff stuffToRepair, StuffAPI stuffAPI, int time)` When the stuff method is called, the house will be repaired.
        * function `public ReadDoc readDocumentation(String doc, int time, Stuff stuff)` The method will create documentation read actions for stuff in the house.
        * function `public FindDoc findDocumentation(Stuff stuff, int time)` The method will create documentation lookup actions for stuff in the house.
        * function `public CallService callService(Stuff stuff, StuffAPI stuffAPI, int time)` The method will create workshop call actions.
      * **Grandpa** _(The class contains methods related to the grandma.)_
      * **Grandma** _(The class contains methods related to the grandma.)_
      * **Mom** _(The class contains methods related to the mom.)_
        * function `public FeedBaby feedBaby(Baby baby, int time)` When the methods are called, the mother feeds the baby.
      * **Person** _(An abstract class contains basic methods for all rooms in the house.)_
        * function `public String getName()` Normal getter
        * function `public int getAge()` Normal getter
        * function `public FeedAnimal feedPet(Pet pet, int time)` When methods are called, another method is called that feeds the animal.
        * function `public void setUsing(boolean using)` Normal setter
        * function `public void setUsedStuff(Usable usedStuff)` Normal setter
        * function `public Usable getUsedStuff()` Normal getter
        * function `public boolean isUsing()` return the true if the person is busy with something.
        * function `public abstract Eat eat(int time, StuffAPI stuffAPI)` When the method are called, the amount of satiety of the people increases.
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **PersonType** _(The enum type is used to define the type of person.)_
        * function `public abstract boolean isBaby()` The method determines whether the baby is or not.
        * function `public abstract String toString()` return a string of the type of person depending on who is calling it.
      * **RepairServiceMaster** _(The class is needed in order to fix any stuff in the house that the father cannot fix.)_
        * function `public Repair fix(Stuff stuffToRepair, StuffAPI stuffAPI, int time) ` When the stuff method is called, the house will be repaired.
    
    **Inhabitant** _(The abstract class Inhabitant contains methods that keep track of which floor the house is on.)_
     * function `public void setInhabitantState(InhabitantState inhabitantState)` Normal setter
     * function `public Room getCurrentRoom()` Normal getter
     * function `public void setCurrentRoom(Room currentRoom)` Normal setter
     * function `public void sleep()` The method will indicate that the inhabitant of the house is sleeping.
     * function `public void wakeUp()` The method will indicate that the inhabitant of the house is awake.
     * function `public abstract void decreaseSatiety()` When calling the method, reduces the satiety of the animal.
     * function `public void setSatiety(int satiety)` When calling the method, set the level of satiety of the animal.
     * function `public abstract boolean checkSatiety()` The method checks the level of satiety in the animal.
     * function `public int getSatiety()` Normal getter
   
   **InhabitantState** _(The enumeration type is used to determine the state of the resident of the house, whether he is sleeping or not.)_

3) **Report** This package contains a package of **actions** and 3 classes related to reports.
    ###Classes used:
    * **The action package contains: (package)repair, (abstract)Action, (enum)ActionType, Broke, ChangeSensorState, Cook, Eat, ElectricityConsumptionDay, ElectricityConsumptionMonth, FeedAnimal, FeedBaby, PutFood, Sleep, TakeFood, Use, WakeUp, WaterConsumptionDay, WaterConsumptionMonth**
      * **The repair package contains : (abstract)AbstractRepairHandler, CallService, CallServiceRepairHandler, FindDoc, FindDocRepairHandler, ReadDoc, ReadDocRepairHandler, Repair, RepairHandler**
        * **AbstractRepairHandler** _(An abstract class is needed to use the chain of responsibility design pattern.)_
          * function `public static void setStuffAPI(StuffAPI stuffAPI)` Normal setter function
          * function `public void setNextHandler(AbstractRepairHandler nextHandler)` Normal setter
          * function `public void repair(Stuff stuff, int level, Person person, int time)` The recursive method calls the handle method in order, which will carry out the action we need.
          * function `abstract protected void handle(Stuff stuff, Person person , int time)` An abstract method, depending on the level, calls different actions from the chain of responsibilities.
          * function `public StuffAPI getStuffAPI()` Normal getter
        * **CallService** _(The class creates an action if you need to call the service.)_
          * function `public Stuff getStuff()` Normal getter
        * **CallServiceRepairHandler** _(The class needs an action call from the chain of responsibility. Call master.)_
        * **FindDoc** _(The class creates an action if you need to find documentation.)_
          * function `public Stuff getStuff()` Normal getter
        * **FindDocRepairHandler** _(The class needs an action call from the chain of responsibility. Find documentation)_
        * **ReadDoc** _(The class creates an action if you need to read the documentation.)_
          * function `public Stuff getStuff()` Normal getter
        * **ReadDocRepairHandler** _(The class needs an action call from the chain of responsibility. Read documentation)_
        * **Repair** _(The class creates an action when we repair any element of type Stuff.)_
          * function `public Stuff getStuffToRepair()` Normal getter
        * **RepairHandler** _(The class needs an action call from the chain of responsibility. Repair stuff)_
      * **Action** _(An abstract class was created to create all the actions that take place in the house.)_
        * function `public int getTime()` Normal getter 
        * function `public ActionType getActionType()` Normal getter
        * function `public Room getRoom()` Normal getter
        * function `public Inhabitant getInhabitant()` Normal getter
      * **ActionType** _(The enumeration type is used to determine the type of report.)_
        * function `public abstract String toString()` The method will return a string for the report.
      * **Broke** _(The class creates an action when something breaks.)_
        * function `public Stuff getBrokenStuff()` Normal getter
      * **ChangeSensorState** _(The class creates an action when the state of the sensors changes.)_
        * function `public Sensor getSensor()` Normal getter
        * function `public String getComment()` Normal getter
      * **Cook** _(The class creates an action when something is cooked.)_
        * function `public StuffAPI getStuffAPI()` Normal getter
      * **Eat** _(The class creates an action when someone eats.)_
        * function `private void eat(int time)` When the method is called, the residents of the house will have an increase in their satiety.
        * function `private void cook(int time)` The method interacts with the microwave (reheats food).
        * function `public String getFood()` Normal getter
        * function `public String randomFood()` The method will choose a random food from the available ones.
        * function `public Stuff getStuff()` Normal getter
      * **ElectricityConsumptionDay** _(The class creates an action when we want to measure the amount of electricity used.)_
        * function `public double getElectricityConsumptionDay()` Normal getter
      * **ElectricityConsumptionMonth** _(The class is created when the action of calculating the consumed electricity for the month is called.)_
        * function `public double getElectricityConsumptionMonth()` Normal getter
      * **FeedAnimal** _(The class creates an action when someone feeds the animal.)_
        * function `public Pet getPet()` Normal getter
        * function `private void feedPet()` When the method is called, the person feeds the animal.
      * **FeedBaby** _(The class creates an action when the mother feeds the baby.)_
        * function `private void feedBaby()` When the method is called, the mom will feed the baby.
      * **PutFood** _(The class creates an action when someone puts food in the refrigerator or microwave.)_
        * function `public String getFood()` Normal getter
        * function ``public Stuff getStuff() Normal getter
      * **Sleep** _(The class creates an action when everyone goes to bed.)_
      * **TakeFood** _(The class creates an action when someone takes food from the refrigerator or from the microwave.)_
        * function `public String getFood()` Normal getter
        * function `public Stuff getStuff()` Normal getter
      * **Use** _(The class creates an action when we want to use any element of type Stuff.)_
        * function `public Usable getStuffToUse()` Normal getter
      * **WakeUp** _(The class creates an action when all residents of the house wake up.)_
      * **WaterConsumptionDay** _(The class creates an action when we want to measure the amount of water spent.)_
        * function `public double getWaterConsumptionDay()` Normal getter
      * **WaterConsumptionMonth** _(The class is created when the action of calculating the consumed water for the month is called.)_
        * function `public double getWaterConsumptionMonth()` Normal getter
    * **Report** _(We use the Report class to store getters and setters.)_
      * function `public void setChangeStateComment(String changeStateComment)` Normal setter
      * function `public void setTime(String time)` Normal setter
      * function `public void setRoom(String room` Normal setter
      * function `public void setPerson(String person)` Normal setter
      * function `public void setStuff(String stuff)` Normal setter
      * function `public void setActionType(ActionType actionType)` Normal setter
      * function `public void setConsumption(double consumption)` Normal setter
      * function `public void setPet(String pet)` Normal setter
      * function `public void setFood(String food)` Normal setter
    * **ReportAPI** _(The class will generate reports and write everything to one file.)_
      * function `public void addReportToFile() ` The method will add a report to the file. 
      * function `public Report createBrokeReport(Broke action)` The method creates a report if something breaks.
      * function `public Report createCookReport(Cook action)` The method creates a report if someone prepares something.
      * function `public Report createEatReport(Eat action)` The method creates a report if someone eats something.
      * function `public Report createFeedAnimalReport(FeedAnimal action)` The method creates a report if someone feeds the animal.
      * function `public Report createFeedBabyReport(FeedBaby action)` The method creates a report if a mother feeds a child.
      * function `public Report createStuffElectricConsumptionReportMonth(ElectricityConsumptionMonth action)` The method creates a report if we want to get the amount of electricity used per month.
      * function `public Report createStuffElectricConsumptionReportDay(ElectricityConsumptionDay action)` The method creates a report if we want to get the amount of electricity used per day.
      * function `public Report createStuffWaterConsumptionReportMonth(WaterConsumptionMonth action)` The method creates a report if we want to get the amount of water used per month.
      * function `public Report createStuffWaterConsumptionReportDay(WaterConsumptionDay action)` The method creates a report if we want to get the amount of water used per day.
      * function `public Report createRepairReport(Repair action)` The method creates a report if the device was repaired.
      * function `public Report createSleepReport(Sleep action)` The method creates a report if everyone is asleep.
      * function `public Report createUseReport(Use action)` The method creates a report if someone uses something.
      * function `public Report createWakeUpReport(WakeUp action)` The method creates a report if everyone is awake.
      * function `public Report createChangeSensorStateReport(ChangeSensorState action)` The method creates a report if the state of the sensor has changed.
      * function `public Report createPutFoodReport(PutFood action)` The method creates a report when someone wants to take food.
      * function `public Report createTakeFoodReport(TakeFood action)` The method creates a report when someone wants to put food.
      * function `public Report createReadDocReport(ReadDoc action)` The method creates a report when the documentation is read.
      * function `public Report createFindDocReport(FindDoc action)` The method creates a report if an action to search for documentation has occurred.
      * function `public Report createCallServiceReport(CallService action)` The method creates a report when a call to the service center occurs.

    * **ReportBuilder** _(The class creates reports and then all reports will be combined into one report.)_
      * function `public void addActionType(ActionType actionType)` The method determines the type of action that is occurring.
      * function `public void addTime(int time)` The method determines when this event occurred.
      * function `public void addDay(int time)` The method will add only the day on which the action took place.
      * function `public void addRoom(Room room)` The method determines where this event occurred.
      * function `public void addPerson(Person person)` The method determines who this event happened to.
      * function `public void addChangeStateComment(String comment)` The method adds to the report why the state stuff has changed.
      * function `public void addStuff(Stuff stuff)` The method determines which sensor this event is associated with.
      * function `public void addConsumption(double consumption)` The method will add the amount of energy expended to the report.
      * function `public void addPet(Pet pet)` The method will add an animal with which the action is taking place.
      * function `public void addFood(String food)` The method will add food to the report.
      * function `public static ArrayList<Report> getArray()` Normal getter
      * function `public static void addReportToList(Report report)` The method will add reports to the list.
      * function `public Report getResult()` The method determines to return to us a ready-made report.

4) **Stuff** The Package contains the **autonomic** and **usable** packages. 
    ###Classes used:        
    * **The autonomic package contains: Blinds, Convector, Humidifier, Lamp, (interface)Sensor**
      * **Blinds** _(The class contains methods related to the blinds.)_
        * function `public Room getRoom()` Normal getter
        * function `public String toString()` The method returns a string that will be sent to the report. 
      * **Convector** _(The class contains methods related to the convector.)_
        * function `public Room getRoom()` Normal getter
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Humidifier** _(The class contains methods related to the humidifier. The humidifier is equipped with humidity sensors in the house)_
        * function `public Room getRoom()` Normal getter
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Lamp** _(The class contains methods related to the lamp.  Also, the lamp is illuminated by sensors with the help of which the light comes on)_
        * function `public Room getRoom()` Normal getter
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Sensor** _(The interface contains methods that will be used by all sensors in the house.)_
        * function `double getWaterConsumptionDay()` Normal getter
        * function `double getElectricityConsumptionDay()` Normal getter
        * function `void measure(Simulation simulation, int time)` The method measures the amount of light or the amount of humidity depending on the type of sensor.
        * function `void changeState(boolean state, double data, int time)` The method changes the state of the sensor.
        * function `String makeChangeComment(double data)` The method creates a comment when the state of the sensor changes.

    * **The usable package contains: (package)microwave, Bike, Car, Computer, (enum)FoodType, Fridge, (interface)KitchenStuff, Ski, (interface)Switchable, TV, (interface)Usable, (interface)Vehicle**
      * **The microwave package contains: CookingFoodState, Microwave, MicrowaveContext, (interface)MicrowaveState, ReadyToCookState**
        * **CookingFoodState** _(The method switches the state of the microwave.)_
        * **Microwave** _(The class contains methods related to the microwave.)_
          * function `public String getDocumentation()` Normal getter
          * function `public void putFood(String food)` Method means that the food was put in the microwave.
          * function `public String takeFood()` Method means that the food was taken from the microwave.
          * function `public String toString() `The method returns a string that will be sent to the report.
        * **MicrowaveContext** _(The method is needed to implement the State Machine pattern.)_
          * function `public Microwave getMicrowave()` Normal getter
          * function `public MicrowaveContext()` The method will set the status variable to its original status.
          * function `public void setMicrowave(Microwave microwave)` Normal setter
          * function `public void setState(MicrowaveState state)` Normal setter
          * function `public boolean isUsed()` The method determines whether a microwave is being used.
          * function `public void putFood(String food)` Method means that the food was put in the microwave.
          * function `public void takeFood()` Method means that the food was taken from the microwave.
          * function `public Use use(Person person, int time, StuffAPI stuffAPI)` The method creates human interaction with the microwave.
          * function `public MicrowaveState getState()` Normal getter
          * function `public void stopUsing(Person person)` The method stops using the microwave.
        * **MicrowaveState** _(The interface is needed to implement the State Machine pattern.)_
          * function `boolean isUsed(MicrowaveContext context)`  The method determines whether a microwave is being used.
          * function `void putFood(MicrowaveContext context, String food)` Method means that the food was put in the microwave.
          * function `void takeFood(MicrowaveContext context)` Method means that the food was taken from the microwave.
          * function `Use use(MicrowaveContext context, Person person, int time, StuffAPI stuffAPI)` The method creates human interaction with the microwave.
          * function `void stopUsing(MicrowaveContext context, Person person)` The method stops using the microwave.
        * **ReadyToCookState** _(The method switches the state of the microwave.)_
      
      * **Bike** _(The class contains methods related to the wheel.)_
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Car** _(The class contains methods related to the auto.)_
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Computer** _(The class contains methods related to the computer.)_
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **FoodType** _(The enumeration type is used to define the type of food.)_
        * function `public abstract String toString()` return food as type string.
      * **Fridge** _(The class contains methods related to the fridge.)_
        * function `public boolean isEmpty()` The method checks if the refrigerator is empty.
        * function `public String toString() ` The method returns a string that will be sent to the report.
        * function `public void updateFridgeConsumption()` The method updates the amount of electricity spent.
      * **KitchenStuff** _(The interface contains methods that will be used by all classes that relate to the KitchenStuff interface.)_
        * function `void putFood(String food)` When calling the methods, put food in the microwave or refrigerator.
        * function `String takeFood()` When calling the methods, take food in the microwave or refrigerator.
        * function `double getElectricityConsumptionDay()` Normal getter
      * **Ski** _(The class contains methods related to the ski.)_
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Switchable** _(The interface contains methods for obtaining consumed electricity and water, devices that turn on and off.)_
        * function `double getElectricityConsumptionDay()` Normal getter
      * **TV** _(The class contains methods related to the TV.)_
        * function `public String toString()` The method returns a string that will be sent to the report.
      * **Usable** _(The interface contains methods that will be used by all classes that relate to the Usable interface.)_
        * function `Use use(Person person, int time, StuffAPI stuffAPI)` We use the method to control the vehicle. Everyone will use the transport for 120 minutes. Then the leaveVehicle method is called which indicates that the ride has ended
        * function `boolean isUsed()` Method checks if someone interacts with our class.
        * function `void stopUsing(Person person)` When the method is called, the person stops interacting with any element, not including the inhabitants of the house.
        * function `Person getPerson()` Normal getter
      * **Vehicle** _(The interface contains methods that will be used by all Vehicle in the house.)_
        * function `void useVehicle(Person person)` When calling the method, we determine who uses our vehicle.
        * function `void leaveVehicle(Person person)` When we call the method, the person leaves the vehicle.
    * **Stuff** _(The interface is used to store the same type for sensors and refrigerator, car, etc.)_
      * function `boolean checkQuality()` Methods checks the usable classes quality.
      * function `void setQuality()` Normal setter
      * function `void decreaseQuality()` When calling methods, the quality of the usable classes decreases.
      * function `void changeStuffState(StuffState stuffState)` The method will change the state of stuff to received.
      * function `Room getRoom()` Normal getter
      * function `String getDocumentation()` Normal getter
    * **StuffAPI** _(The API class contains functions that are used to manage all the stuff at home.)_
      * function `public Kitchen getKitchen()` Normal getter
      * function `public void updateStuffQuality(int time)` The method call will decrease the quality of each stuff in the list.
      * function `public void updateConsumption(int day)` The method updates the amount of water and electricity used per day.
      * function `public void updateMonthConsumption(int day)` The method determines what month is at the time the method is called and calculates a more accurate use of the monthly use of electricity and water.
      * function `public void countMonthCons(int startDay, int dayNum)` The method will collect all the amounts of water and electricity used for the month.
      * function `public void changeStuffState(StuffState stuffState, Stuff stuff)` The method will change the state stuff to the received state.
      * function `private AbstractRepairHandler getChainOfHandlers()` return the chain of responsibilities from the very first element.
      * function `private Dad getDad()` Normal getter
      * function `public void repairStuff(Stuff stuffToRepair, int time)` The method will fix stuff.
      * function `public void subscribeAllStuff(Subscriber sub)` When the method is called, all stuff in the house will be subscribed to "updates".
      * function `public ArrayList<Stuff> getStuffList()` Normal getter
      * function `public void stopUsingStuff(Person person, Usable usedStuff)` When the method is called, the person stops interacting with any element, except for the inhabitants of the house.
      * function `public Use useStuff(Person person, int time, Usable stuff)` When the method is called, the person begins to interact with some element besides the inhabitants of the house.
      * function `public ArrayList<Sensor> getSensorList() ` Normal getter
      * function `public void measureSensor(Simulation simulation, Sensor sensor, int time)` The method calls the measure method on a specific sensor.
    * **StuffState** _(The enumeration type is used to determine the state of stuff.)_

5) **Classes and interfaces outside of any packages**
    ###Classes used:
   * **ActionSubscribers** _(The class is required to update the report, the observer design pattern is applied.)_
   * **HomeUtils** _(The class contains methods that contain frequently repeated code in different classes.)_
     * function `public static void changeRoom(Inhabitant inhabitant, Room newRoom)` The method simply changes the room of the resident of the house.
     * function `public static void stopUseStuff(Person person, StuffAPI stuffAPI)` When the method is called, the person stops interacting with the elements of the house in addition to the inhabitants of the house . 
   * **Publisher** _(The interface is used to use the observer pattern design.)_
     * function `void subscribe(Subscriber sub)` The method adds subscriptions to the list.
     * function `void unsubscribe(Subscriber sub)` The method removes subscriptions from the list.
     * function `void notifySubscribers(Action action)` The method notifies the subscriber of the action.
   * **Simulation** _(The class runs a simulation of the whole house and the lives of the inhabitants in this house.)_
     * function `public void runSimulation()` The method will start a simulation.
     * function `public void updateConsumption(int day)` The method increases the amount of consumed electricity and water in one day.
     * function `public void updateSensors(int time)` The method updates all sensors in the house (their state).
     * function `public ReportAPI getReportAPI()` Normal getter
     * function `public Weather updateWeather(int time)` The method updates the weather depending on the time obtained. 
     * function `public void updateHumidity(Weather weather)` The method updates the humidity depending on the weather.
     * function `public void updateLightLevel(Weather weather, int time)` The method updates the light level depending on the weather.
     * function `public void updateTemperatureLevel(Weather weather)` The method updates the temperature depending on the weather.
     * function `public void generateActions(int time)` The method creates any events in the house.
     * function `public Usable randomUsable(ArrayList<Stuff> stuffList)` The method selects a random element of type Usable.
     * function `public int calculateHours(int time)` The method calculates what hour at the time of the call.
     * function `public String randomFood()` Method selects random food.
     * function `public double getCurrentTemperature()` Normal getter
     * function `public int getCurrentHumidity()` Normal getter 
     * function `public int getCurrentLightLevel()` Normal getter
   * **Subscriber** _(The interface is needed to notify subscribers. Observer pattern design)_
     * function `void update(Action action)` The method is needed to update the subscriber notification.
   * **Weather** _(The enumeration type is used to determine the month.)_
     * function `public int getRandomNumber(int min, int max)` The method selects a random number from an interval of numbers.
     * function `public abstract double getTemperature()` Normal getter
     * function `public abstract int getHumidity()` Normal getter
     * function `public abstract int getLightLevel(int time)` Normal getter
        
