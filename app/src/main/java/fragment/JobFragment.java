package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanshu.emex.R;

import java.util.ArrayList;

import adapter.DisplayAdapter;
import model.JobHistoryModel;

/**
 * job fragment
 */
public class JobFragment extends Fragment {

    private static final int MODE = 0, MODE1 = 1;
    private String jobMode;
    private ArrayList<JobHistoryModel> jobHistoryModelArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private JobHistoryModel jobHistoryModel;
    private DisplayAdapter displayAdapter;

    /**
     *
     * @param jobMode mode
     */
    public JobFragment(final String jobMode) {
        this.jobMode = jobMode;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, final Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_job, viewGroup, false);
        if ("jobhistory".equals(jobMode)) {
            jobHistoryModel = new JobHistoryModel("hitesh", "331", "22/10/2015 04:15", "6.5km", "441", "2900", "20min");
            displayAdapter = new DisplayAdapter(jobHistoryModelArrayList, MODE);
        } else {
            jobHistoryModel = new JobHistoryModel("ramesh", "440A", "05/12/2016 07:30", "10km");
            displayAdapter = new DisplayAdapter(jobHistoryModelArrayList, MODE1);
        }
        jobHistoryModelArrayList.add(jobHistoryModel);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_display);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(displayAdapter);
        recyclerView.setHasFixedSize(true);
        return view;

    }

}