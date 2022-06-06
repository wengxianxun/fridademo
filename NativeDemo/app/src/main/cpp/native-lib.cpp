#include <jni.h>
#include <string>
using namespace std;
int max1(int num1,int num2);

#define random(x) rand()%(x)

extern "C" JNIEXPORT jstring JNICALL

Java_com_wxx_nativedemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    int result = max1(random(100), random(100));

    std::string hello = "Hello from C++";
    string hello2 = hello.append(to_string(result));

    return env->NewStringUTF(hello2.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_wxx_nativedemo_AlgJni_GetTest(JNIEnv *env, jclass clazz, jstring file_path) {
    // TODO: implement GetTest()
    std::string hello = "Hello from C++";

    return env->NewStringUTF(hello.c_str());;
}

int max1(int num1,int num2){
    int result;

    if(num1 > num2)
        result = num2;
    else
        result = num2;

    return result;
}