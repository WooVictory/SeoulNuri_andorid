# 2018년 서울시 앱 공모전 출품작 SeoulNuri

2018년도 서울시 앱 공모전 출품작 SeoulNuri 입니다. 아래와 같은 구성원으로 팀을 이뤘습니다. 
기획 - 1
디자인 - 1
안드로이드 - 4
서버 - 3



## Overview

관광객들에게 무장애 여행을 제공하는 SeoulNuri 입니다.


## Develop Environment

* **Language** - Kotlin, Java
* Minimum SDK Version - 23
* Target SDK Version - 28
* Optimization Device - Nexus 6s

## Library


1. **layout**

* CardView : implementation 'com.android.support:cardview-v7:28.0.+'
* RecyclerView : implementation 'com.android.support:recyclerview-v7:28.0.+'
* GridLayout : implementation 'com.android.support:gridlayout-v7:28.0.+'
* SlidingUpPanelLayout : implementation 'com.sothree.slidinguppanel:library:3.4.0'

2. **HTTP REST API**

* retrofit2 : implementation 'com.squareup.retrofit2:retrofit:2.4.0'

3. **JSON**

* JSON to GSON : implementation 'com.squareup.retrofit2:converter-gson:2.1.0'

4. **Material design**

* implementation 'com.android.support:design:28.0.0-rc01'

5. **kakao auth**

* implementation group: 'com.kakao.sdk', name: 'usermgmt', version: project.KAKAO_SDK_VERSION

6. **Google map**

* implementation 'com.google.android.gms:play-services-maps:15.0.1'
* implementation 'com.google.android.gms:play-services-location:15.0.1'

7. **Image loader**

* Glide : implementation 'com.github.bumptech.glide:glide:4.7.1'




