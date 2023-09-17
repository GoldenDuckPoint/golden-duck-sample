# 황금오리 SDK 연동

- 본 프로젝트는 황금오리 SDK를 적용한 샘플앱입니다.
- 황금오리 SDK 사용을 위해서는 반드시 AccessKey를 발급 받아야 합니다.
- 본 프로젝트는 KOTLIN 기반이며, AAR SDK 연동 방식은 Java도 동일합니다.

## Gradle 설정
- build.gradle(Module) 파일에서 아래 코드를 추가합니다.

```groovy
dependencies {
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    implementation 'com.squareup.okhttp3:okhttp'
    implementation 'com.squareup.okhttp3:logging-interceptor'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.retrofit2:converter-scalars:2.9.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.9.0"

    implementation "io.reactivex.rxjava2:rxandroid:2.1.1"
    implementation "io.reactivex.rxjava2:rxjava:2.2.17"

    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

    implementation 'com.google.android.gms:play-services-ads-identifier:18.0.1'
    implementation 'com.google.guava:guava:28.0-android'

    implementation files('libs/gduck-lib.1.0.1.aar')
}
```

## AndroidManifest 설정
- Android 13 이상인 경우 다음의 권한이 필요합니다.
```xml
<uses-permission android:name="com.google.android.gms.permission.AD_ID"/>
```
- 설치 보상형 광고의 경우 다음의 권한이 필요합니다.
   구글 플레이스토어 앱 등록 시 구글 심사 담당자의 추가적인 요청이 있을 수 있습니다.
```xml
<uses-permission
    android:name="android.permission.QUERY_ALL_PACKAGES"
    tools:ignore="QueryAllPackagesPermission" />
```

## 황금오리 SDK 사용
#### 초기화 및 실행
- 어플리케이션 클래스에서 초기화 함수를 호출합니다.
```kotlin
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initInstance()
    }

    private fun initInstance() {
        // SDK 초기화
        GoldenDuck.init(this, "{AccessKey}")
    }
}
```
- GDUCK SDK 무료 포인트 충전 화면 실행
- {UserID}는 로그인 사용자의 ID이며, 생략 시 광고 ID를 기준으로 처리됩니다.
```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            // 무료 포인트 적립 실행
            GoldenDuck.launch(this, "{UserID}")
        }
    }
}
```
