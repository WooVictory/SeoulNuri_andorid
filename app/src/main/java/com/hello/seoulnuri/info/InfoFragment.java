package com.hello.seoulnuri.info;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.ToggleButton;

import com.hello.seoulnuri.R;
import com.hello.seoulnuri.model.InfoData;
import com.hello.seoulnuri.model.InfoItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class InfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ToggleButton tgbtn1; // all
    ToggleButton tgbtn2; // eye
    ToggleButton tgbtn3; // ear
    ToggleButton tgbtn4; // wheel
    ToggleButton tgbtn5; // elder
    ArrayList<InfoItem> infoList;
    ArrayList<InfoData> datas; // 외부 연결 필요

    private RecyclerView recyclerview;
    private LinearLayoutManager manager;

    private RelativeLayout relativeLayout;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;
    private FragmentTabHost tabHost;
    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     /*   * @param param1 Parameter 1.
     /*   * @param param2 Parameter 2.*/
    /*  * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(/*String param1, String param2*/) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        /*Intent intent = new Intent(getActivity(),InfoStartActivity.class);
        startActivity(intent);*/
        // intent.putExtra(list)

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmeng

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        TabHost tabHost1 = (TabHost) view.findViewById(R.id.tabHost);
        tabHost1.setup();

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.tourinfo222);
        ts1.setIndicator("관광");
        tabHost1.addTab(ts1);

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.stayinfo);
        ts2.setIndicator("숙박");
        tabHost1.addTab(ts2);

        relativeLayout = (RelativeLayout)view.findViewById(R.id.rl_hidden);

        //toggles
        tgbtn1 = (ToggleButton)view.findViewById(R.id.tg_total); // total

        tgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgbtn1.isChecked()){
                    tgbtn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.filter_all_active));
                    //  relativeLayout.setVisibility(View.VISIBLE);
                }
                else {
                    tgbtn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.filter_all_g));
                    // relativeLayout.setVisibility(View.GONE);
                }
            }
        });

        tgbtn2 = (ToggleButton)view.findViewById(R.id.tg_eye); // eye

        tgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgbtn2.isChecked()){
                    tgbtn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.filter_eye_g));
                    relativeLayout.setVisibility(View.VISIBLE);
                }
                else {
                    tgbtn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.filter_all_g));
                    relativeLayout.setVisibility(View.GONE);
                }
            }
        });

        //세부필터 관련 내용 개발 필요


        //메인 view,관광
        recyclerview = (RecyclerView) view.findViewById(R.id.rv_tour);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        infoList = new ArrayList<InfoItem>();
        datas = new ArrayList<InfoData>();

        InfoItem[] item=new InfoItem[4];
        item[0]=new InfoItem(R.drawable.img_gyeongbok, 3,2,"경복궁");
        item[1]=new InfoItem(R.drawable.img_mongchoen, 2, 20,"몽천유적지");
        item[2]=new InfoItem(R.drawable.img_sudo, 4, 10,"수도");
        item[3]=new InfoItem(R.drawable.img_kyeong_hee, 3.5, 8, "경희궁");
        Log.e("drawable 확인","" + item[0].getTitle()+"ddd "+R.drawable.img_gyeongbok);

        InfoData[] data = new InfoData[4];
        data[0] = new InfoData(R.drawable.img_gyeongbok_info, "조선시대에 만들어진 다섯 개의 궁궐 중 첫 번째로 만들어진 곳으로, 조선 왕조의 법궁이다. 한양을 도읍으로 정한 후 종묘, 성곽과 사대문, 궁궐 등을 짓기 시작하는데 1394년 공사를 시작해 이듬해인 1395년에 경복궁을 완성한다.\n" +
                "\n" +
                "‘큰 복을 누리라’는 뜻을 가진 ‘경복(景福)’이라는 이름은 정도전이 지은 것이다. 왕자의 난 등이 일어나면서 다시 개경으로 천도하는 등 조선 초기 혼란한 정치 상황 속에서 경복궁은 궁궐로서 그 역할을 제대로 못하다가 세종 때에 이르러 정치 상황이 안정되고 비로소 이곳이 조선 왕조의 중심지로 역할을 하게 된다.");
        data[1]=new InfoData(R.drawable.img_mongchoen, "몽천유적지");
        data[2]=new InfoData(R.drawable.img_sudo, "수도");
        data[3]=new InfoData(R.drawable.img_kyeong_hee,  "경희궁");

        for(int i=0;i<4;i++) {infoList.add(item[i]); datas.add(data[i]);}

        //카드뷰 배치
        manager = new GridLayoutManager(getActivity(), 2);

        recyclerview = (RecyclerView) view.findViewById(R.id.rv_tour);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(manager);

        //Info adapter 연결
        InfoAdapter adapter = new InfoAdapter(getActivity(),infoList,datas);
        Log.e("onCreate[infoList]", "" + infoList.size());
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //숙박

       /* recyclerview = (RecyclerView)view.findViewById(R.id.rv_stay);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(manager);*/

        //Stay adapter 연결




        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
