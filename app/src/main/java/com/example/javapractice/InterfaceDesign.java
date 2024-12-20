package com.example.javapractice;

/**
 [실용주의 프로그래머, 158]
 부엌용 믹서의 인터페이스를 설계하라.
 이 믹서는 나중에 웹으로 쓸 수 있도록 사물 인터넷IoT으로 연결될 예정이지만
 지금으로서는 믹서를 제어할 수 있는 인터페이스만 있으면 된다.
 ① 속도를 열 단계로 설정할 수 있는데 ② 0은 중지를 의미한다.
 ③ 비어 있는 상태에서는 작동할 수 없고, ④ 한 번에 한 칸씩만 속도를 바꿀 수 있다.
 즉 0에서 1, 1에서 2는 되지만, 0에서 2는 안 된다.
 다음과 같은 메서드가 있을 때, 적절한 선행, 후행 조건과 불변식을 추가하라.

 int getSpeed()
 void setSpeed(int x)
 boolean isFull()
 void fill()
 void empty()
 **/


interface Mixer1 {
    /**
     * 현재 속도를 반환합니다.
     * @return 현재 속도 (0~10)
     * @invariant 0 <= speed <= 10
     */
    int getSpeed();

    /**
     * 속도를 설정합니다.
     * @param x 새로 설정할 속도
     * @precondition isFull() == true (Mixer가 비어있지 않아야 함)
     * @precondition 0 <= x <= 10
     * @precondition Math.abs(x - getSpeed()) == 1 (한 번에 한 단계만 변경 가능)
     * @postcondition getSpeed() == x
     */
    void setSpeed(int x);

    /**
     * 믹서가 비어있는지 확인합니다.
     * @return 믹서가 비어 있으면 false, 그렇지 않으면 true
     */
    boolean isFull();

    /**
     * 믹서에 재료를 채웁니다.
     * @postcondition isFull() == true
     */
    void fill();

    /**
     * 믹서를 비웁니다.
     * @postcondition isFull() == false
     * @postcondition getSpeed() == 0
     */
    void empty();
}

interface Mixer2 {

    /**
     * 클래스 불변식
     * @invariant getSpeed > 0
     *          implies isFull()   // 빈 상태로는 돌리지 못한다.
     * @invariant getSpeed > 0 &&
     *          getSpeed() < 10
     * 선행 조건 , 후행 조건
     * @Pre Math.abs(getSpeed() - x) <= 1  // 한 단계씩만 바꿀 수 있다.
     * @Pre x >= 0 && x <= 10   // 요청한 속도가 되었다.
     */

    void setSpeed(final int x);
        /**
         * @pre !isFull()   // 차 있는데 또 채우지 않는다.
         * @post isFull()   // 수행되었는지 확인한다.
         */



    void fill();
        /**
         * @pre !isFull()   // 비어 있는데 또 비우지 않는다.
         * @post isFull()   // 수행되었는지 확인한다.
         */

    void empty();

}




