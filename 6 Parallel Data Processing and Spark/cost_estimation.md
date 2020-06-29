* R.a>200 : clustered index scan  
T1 = X * B(R) = (250-200) / (250-150) * 1000 = 500  

* R.a=S.a : block-at-a-time nested loop join  
T2 = T(R') (X * T(S)) = 5 * 10^4 * (1/250) * 4 * 10^4 = 8 * 10^6  

* S.b=U.b : unclustered nested loop join  
T3 = T(RS) (X' * T(U)) = 4 * 10^8 * (250/1000) * (1/250) * 10^4 = 4 * 10^9  

* Overall  
T = T1 + T2 + T3 = 4008000500
