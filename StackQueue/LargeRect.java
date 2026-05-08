class LargeRect {
    public int largestRectangleArea(int[] heights) {
		int hlen = heights.length;
		int[] pstack = new int[hlen]; int cur = 0, result = 0, tmp = 0, j = 0;
		
		int lh = heights[0]; pstack[cur] = 0; result = heights[0];
		for(int i = 1; i < hlen; i++) {
			if(heights[i] > heights[cur]) {
				cur++; heights[cur] = heights[i]; pstack[cur] = i;
			} else if (heights[i] < heights[cur]) {
				for(j = cur; j >= 0; j--) {
					if(heights[i] < heights[j]) {
						tmp = heights[j] * ( i - pstack[j]);
						if(tmp > result) result = tmp;
					} else {
						break;
					}
				}
				cur = j + 1;
				heights[cur] = heights[i];
			}
		}
		
		for(int k = cur; k >= 0; k--) {
			tmp = heights[k] * (hlen - pstack[k]);
			if(tmp > result) result = tmp;
		}

        return result;
    }
}