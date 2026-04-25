# 📑 Analysis: 절댓값 힙 (BOJ 11286)

> **Category**: Data Structure (Priority Queue / Heap)  
> **Level**: Silver I  
> **Key Concept**: Custom Comparator, Priority Queue Optimization

---

## 1. 문제 정의 및 복잡도 분석
* **목표**: 절댓값이 가장 작은 값을 우선적으로 출력하되, 절댓값이 같다면 실제 값이 더 작은(음수) 값을 먼저 출력하는 자료구조를 구현한다.
* **입력 규모**: 연산의 개수 $N=100,000$.
* **제한 사항**: 시간 제한 1초.
* **해결 전략**: 삽입과 삭제 시 $O(\log N)$을 보장하는 **우선순위 큐(Priority Queue)**를 사용하여 전체 시간 복잡도 $O(N \log N)$으로 해결한다.

---

## 2. 알고리즘 설계 (Architecture)

### 🏗️ Data Structure
* **`PriorityQueue<Integer>`**: 내부적으로 **최소 힙(Min Heap)** 구조를 사용하며, 정렬 기준을 커스텀하게 설정하여 우선순위를 제어한다.

### ⚙️ Core Logic (Custom Comparator)
자바의 `Comparator` 인터페이스를 람다식으로 재정의하여 정렬 조건을 설정한다.
1. **조건 1**: 두 수의 절댓값이 다를 경우 → **절댓값 기준 오름차순** 정렬 (`abs1 - abs2`).
2. **조건 2**: 두 수의 절댓값이 같을 경우 → **실제 값 기준 오름차순** 정렬 (`o1 - o2`).

---

## 3. 핵심 인사이트 (Deep Dive)

### 🚀 Comparator와 힙의 동작 원리
* `compare(o1, o2)` 함수에서 **음수**를 반환하면 앞에 있는 `o1`이 우선순위를 갖고 트리 위쪽으로 이동(Up-heap)한다.
* `o1 - o2` 연산 결과가 음수라면 `o1`이 더 작다는 의미이므로, 절댓값이 같을 때 음수가 양수보다 먼저 추출되도록 보장한다.

### ⚡ 실무적 고려 (Performance)
* **I/O 최적화**: $10$만 개의 연산을 효율적으로 처리하기 위해 `BufferedReader`와 `StringBuilder`를 사용해 입출력 병목 현상을 방지했다.
* **방어적 코드**: `isEmpty()` 체크를 통해 큐가 비어있는 상태에서 `0` 입력 시 `0`을 안전하게 출력하도록 설계했다.

---

## 4. Troubleshooting
* **문제**: 초기 설계 시 절댓값이 같을 때의 2차 정렬 조건을 누락하면 `-1`과 `1`의 출력 순서가 보장되지 않음.
* **해결**: `if(abs1 == abs2)` 구문을 추가하여 실제 수치 비교를 2차 기준으로 설정해 데이터 무결성을 확보함.

