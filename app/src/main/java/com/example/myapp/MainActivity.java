package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private Home home;
    private Assignment assignment;
    private Fees fees;
    private Attendance attendance;
    private Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all fragments
        home = new Home();
        assignment = new Assignment();
        library = new Library();
        fees = new Fees();
        attendance = new Attendance(); // Ensure this is initialized here

        // Find views by ID
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottambar);

        // Set the toolbar title
        toolbar.setTitle("Student App");

        // Set the default fragment
        setFragment(home);
        setFragment(assignment);

        // Set up the BottomNavigationView's item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    setFragment(home);
                } else if (item.getItemId() == R.id.assignment) {
                    setFragment(assignment);
                } else if (item.getItemId() == R.id.fee) {
                    setFragment(fees);
                } else if (item.getItemId() == R.id.library) {
                    setFragment(library);
                }else if (item.getItemId() == R.id.attendance) {
                    setFragment(attendance);
                }
                return false;
            }
        });
    }

    // Method to set the fragment
    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}
