# AsyncTask-Accelerometer

## Learning Objective
> Create a simple Accelerometer App that stimulates ’N’ no of times the random values for X, Y and Z dimensions for every second. Use AsyncTask to run the background computation and update the UI simultaneously.

**Step 1:** Develop an android app with three TextViews to show all the three (X, Y, Z) dimension values and get the user input for the simulation count using EditText as shown in the figure 1.1. The **GENERATE** button is to start the *AsyncTask* functions and the **Cancel** button is to end / close the app. 

[![Figure 1.1](https://i.imgur.com/pQccJXS.png)](https://i.imgur.com/pQccJXS.png)

**Step 2:**  *AsyncTask* provides easy way to use the UI thread. I have created MyTask class that extends *AsyncTask*. Inside this class, the *doInBackground* method allows to perform the necessary computation to simulate random values for the three dimensions for every second for ’N’ number of times in the background as shown in the figure1.3. The *onProgressUpdate* method is called using *publishProgress* to publish the computed values with the simulation count on the UI without having to manipulate any threads and/or handlers.

**Step 3:** When the user gives simulation count as **4** and clicks **GENERATE** button, the AsyncTask class is executed and random values are simulated and shown in the UI with the entire log details at the bottom as shown in the figure1.4

[![Figure 1.2](https://i.imgur.com/2ewfYDv.png)](https://i.imgur.com/2ewfYDv.png)

**Step 4:** User can edit the input value and click the **GENERATE** button to simulate new set of random numbers. In figure 1.4, the new input value is **20**. On click of **GENERATE**, it simulates **20** set of random values as shown in figure1.5. I have enabled the scroll as vertical for log TextView at the bottom in the UI

[![Figure 1.4](https://i.imgur.com/NmLq1D2.png)](https://i.imgur.com/NmLq1D2.png)

[![Figure 1.5](https://i.imgur.com/ymZwgqu.png)](https://i.imgur.com/ymZwgqu.png)

### Live Demo
[LINK](http://g.recordit.co/gTE7I3COME.gif)

### Reference
- https://www.youtube.com/watch?v=Z1ALt3dhIDk
- https://developer.android.com/reference/android/os/AsyncTask.html
- https://www.youtube.com/watch?v=EThkglxLxSM

