import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        // 필요한 물품 종류 개수
        int itemsRemaining = want.length;
        
        // 총 필요한 물품 개수
        int totalItemsNeeded = 0;
        
        // 각 물품별로 필요한 수량을 저장할 HashMap 생성
        HashMap<String, Integer> itemMap = new HashMap<>();

        // 필요한 물품 종류와 수량을 itemMap에 저장하고, 총 필요한 물품 개수를 계산
        for (int i = 0; i < want.length; i++) {
            itemMap.put(want[i], number[i]);
            totalItemsNeeded += number[i];
        }

        // 현재까지 할인 목록에서 추적 중인 아이템들을 저장할 deque
        ArrayDeque<String> deque = new ArrayDeque<>();

        int validPeriodCount = 0;  // 조건을 만족하는 할인 기간의 개수

        // 할인 품목 목록을 순회
        for (String currentItem : discount) {
            // 현재 아이템이 필요한 물품 중 하나인지 확인
            if (itemMap.containsKey(currentItem)) {
                int itemCount = itemMap.get(currentItem);
                
                // 해당 물품이 1개 남았다면, itemsRemaining를 감소
                if (itemCount == 1) {
                    itemsRemaining--;
                }
                
                // 물품 수량을 1 줄임
                itemMap.put(currentItem, itemCount - 1);
            }

            // deque에 현재 할인 물품 추가
            deque.addLast(currentItem);

            // deque의 크기가 총 필요한 물품 수를 초과하면 맨 앞의 아이템 제거
            if (deque.size() > totalItemsNeeded) {
                String removedItem = deque.removeFirst();
                
                // 제거된 아이템이 필요한 물품 중 하나라면 그 수량을 다시 증가
                if (itemMap.containsKey(removedItem)) {
                    int removedItemCount = itemMap.get(removedItem);
                    
                    // 수량을 다시 1 증가시키고, 0에서 증가하면 itemsRemaining를 증가
                    itemMap.put(removedItem, removedItemCount + 1);
                    if (removedItemCount == 0) {
                        itemsRemaining++;
                    }
                }
            }

            // 필요한 물품 수량이 모두 만족되면 유효한 할인 기간으로 간주하고 카운트 증가
            if (itemsRemaining == 0) {
                validPeriodCount++;
            }
        }

        // 유효한 할인 기간의 개수 반환
        return validPeriodCount;
    }
}
