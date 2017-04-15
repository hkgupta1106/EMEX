package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.himanshu.emex.R;

import java.util.ArrayList;

import model.JobHistoryModel;


public class DisplayAdapter extends android.support.v7.widget.RecyclerView.Adapter<DisplayAdapter.ViewHolder> {


    private ArrayList<JobHistoryModel> jobHistoryModellist;
    private JobHistoryModel jobHistory;
    private int mode;

    /**
     * @param jobHistoryModellist student arraylist
     * @param mode view pager mode
     */
    public DisplayAdapter(final ArrayList<JobHistoryModel> jobHistoryModellist, final int mode) {
        this.jobHistoryModellist = jobHistoryModellist;
        this.mode = mode;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        jobHistory = jobHistoryModellist.get(position);

        if (mode == 0) {
            holder.tvAddress.setText(jobHistory.getPickUpAddress());
            holder.tvName.setText(jobHistory.getName());
            holder.tvKm.setText(jobHistory.getKiloMeter());
            holder.tvDate.setText(jobHistory.getDate());
            holder.tvDestinationAddress.setText(jobHistory.getDestinationAddress());
            holder.tvRideTime.setText(jobHistory.getRideTime());
        } else {
            holder.tvAddress.setText(jobHistory.getPickUpAddress());
            holder.tvName.setText(jobHistory.getName());
            holder.tvKm.setText(jobHistory.getKiloMeter());
            holder.tvDate.setText(jobHistory.getDate());

        }
    }

    @Override
    public int getItemCount() {
        return jobHistoryModellist.size();
    }


    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {


        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ride_details, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        /**
         * return view holder
         */
        return viewHolder;
    }


    /**
     * view holder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvKm, tvName, tvAddress, tvDestinationAddress, tvRideTime, tvAmmount;
        private LinearLayout lllayout;

        /**
         * @param itemView itemm view
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvKm = (TextView) itemView.findViewById(R.id.tv_km);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            tvDestinationAddress = (TextView) itemView.findViewById(R.id.tv_destination_address);
            tvAmmount = (TextView) itemView.findViewById(R.id.tv_payment);
            tvRideTime = (TextView) itemView.findViewById(R.id.tv_time);

            lllayout = (LinearLayout) itemView.findViewById(R.id.lllayout);
            if (mode == 1) {
                tvDestinationAddress.setVisibility(View.INVISIBLE);
                lllayout.setVisibility(View.GONE);

            }

        }
    }
}