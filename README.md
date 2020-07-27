## Android-MVVM

안드로이드 MVVM 모델을 공부하면서 정리한 README 입니다.



## MVVM Model ??



MVP Model이란, 안드로이드 패턴중에 하나입니다. View, ViewModel, Model로 구성되어 있습니다.

</br>

**View** - ViewModel에게 이벤트나 데이터 요청을 합니다.

**ViewModel** - View와 Model 사이의 매개체 역할을 합니다. Model에서 제공받은 데이터를 View로 보내줍니다.

**Model** - 데이터를 처리합니다.

</br>

MVVM 패턴에 대해 설명을 하면,



**View**

- UI를 의미합니다.
- UI 업데이트를 위해 ViewModel과 바인딩합니다. 즉, View가 ViewModel에 구독을 하고 ViewModel의 상태가 변경되면 UI를 갱신합니다.



**ViewModel**

- View와 Model 사이의 매개체 역할을 합니다.
- Model에서 받은 데이터를 View에게 **이벤트**로 보내게됩니다.
- 여러개의 Fragment가 하나의 ViewModel을 가질 수 있습니다.
- visibility, 네트워크 상태등의 Model의 상태 관리를 합니다.
- **View의 Context등 View에 대한 정보를 가지면 안됩니다.** View의 정보를 가진다면 메모리누수가 발생합니다.
- 앱이 죽으면 ViewModel도 사라지기 때문에 경우에 따라 onSaveInstanceState를 통해 복구할 데이터를 저장해야 합니다.



**Model**

- ViewModel에서 데이터를 가져갈 수 있게 준비하고 **이벤트**를 보냅니다.
- 여기서는 DB, Network,  SharedPreference 등 데이터에 관련된 내용을 처리합니다.

</br>

## Android Architecture Component ( ACC )

구글이 제공하는 [ACC](https://developer.android.com/topic/libraries/architecture)는 MVVM 패턴을 사용하여 개발을 할 때 편하게 개발 할 수 있도록 해주는 라이브러리입니다. 

- ViewModel은 UI관련 데이터를 저장합니다.
- LiveData를 통해 값이 변경되면 View에게 알려주는 데이터 개체를 만듭니다.
- Room은 RxJava, LiveData, Observable을 반환하는 SQLite 개체 매핑 라이브러리입니다.

</br>

![MVVM-Pattern](https://github.com/Im-Tae/Android-MVVM-Example/blob/master/Image/mvvm-architecture.png?raw=true)

</br>

Activity/Fragment는 ViewModel을, ViewModel에는 LiveData를 가지고 있으며 Repository를 알고 있습니다. 각 구성요소는 하나의 구성요소에만 종속됨을 볼 수 있습니다.



ACC에서 더 다양한 것들을 제공하기 때문에 한번쯤 확인하면 좋을 것 같습니다.



## LiveData

**LiveData?**

- Observable Data Holder Class로 특정 데이터를 Observable하게 만들게 됩니다.
- ViewLifecycle에 따라 필요한 일을 알아서 처리해줍니다.

**특징**

- 하나의 데이터에만 Observe할 수 있다.
- LifeCycleOwner interface를 구현해야 한다.
- View가 destroy되면 알아서 Observe를 해제한다.



## Repository

- 뷰모델과 상호작용하기 위한 데이터 API를 들고 있는 클래스입니다.
- 앱에 필요한 데이터를 가져옵니다.
- 앱의 데이터를 관리합니다.



## Room

- SQLite 데이터베이스를 편하게 사용하게 해주는 라이브러리이다.



전체적인 구조는 코드로 확인 바랍니다.