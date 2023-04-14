import java.util.Random;

public class SortingClass {

	void merge_sort_2_parts(int arr[], int first, int last) {
		if (first < last) {
			int center = (first + last) / 2;   // �kiye b�l�m i�lemini yapaca��m�z merkez noktay� belirleriz.

			merge_sort_2_parts(arr, first, center);     // �lk eleman ve merkeze kadar olan k�s�m ilk par�a, merkezden 1 ad�m sonraki elemandan son elemana
			merge_sort_2_parts(arr, center + 1, last);     // kadar olan k�s�m da ikinci par�a olur ve bunlar� yeniden ayn� fonksiyonla �a��r�r�z.

			merge_2_parts(arr, first, center, last);   // Dizideki elemanlar�n s�ralanmas� i�lemini bu fonksiyon yapar.
		}
	}

	void merge_2_parts(int arr[], int first, int center, int last) {
		int n1 = center - first + 1;   // �lk par�an�n eleman say�s�
		int n2 = last - center;        // �kinci par�an�n eleman say�s�
		                            
		int F[] = new int[n1];    // Par�alar� tutmak i�in 2 yeni array olu�tururuz.
		int L[] = new int[n2];

		for (int i = 0; i < n1; ++i)  // Merkeze kadar olan elemanlar� ilk arraye,
			F[i] = arr[first + i];    // merkezden sonrakileri ise ikinci arraye atar�z.
		for (int j = 0; j < n2; ++j)
			L[j] = arr[center + 1 + j];

		int i = 0, j = 0;    // A�t���m�z iki arrayin indexleri

		int k = first;
		while (i < n1 && j < n2) {     // �ki arrayde de eleman varsa d�ng� devam eder. 
			if (F[i] <= L[j]) {       // Hangi arraydeki eleman daha k���kse onu al�p ana arrayde ilk eleman�n oldu�u yere koyar�z.
				arr[k] = F[i];       // Sonra ana arrayin indexi olan k 1 tane b�y�r ve kar��la�t�rmaya devam ederek ana arrayi doldururuz.
				i++;
			} else {
				arr[k] = L[j];
				j++;
			}
			k++;
		}

		while (i < n1) {       // E�er arraylerden birinin eleman say�s� biterse di�er arraydeki elemanlarla devam ederiz. 
			arr[k] = F[i];    
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = L[j];
			j++;
			k++;
		}
	}

	void merge_sort_3_parts(int arr[], int first, int last) {
		if (first < last) {
			int center_1 = first + (last - first) / 3;       // Bu sefer 3 grup olu�turaca��m�z i�in 2 tane noktaya ihtiyac�m�z var.
			int center_2 = first + 2 * (last - first) / 3;   // Bu i�lemlerle gruplar� e�it b�lecek 2 nokta belirliyoruz.

			merge_sort_3_parts(arr, first, center_1);          // Belirledi�imiz noktalar, ilk eleman ve son eleman aras�nda 3 gruba b�l�yoruz.
			merge_sort_3_parts(arr, center_1 + 1, center_2);                           
			merge_sort_3_parts(arr, center_2 + 1, last);

			merge_3_parts(arr, first, center_1, center_2, last);    // S�ralama i�in yolluyoruz.
		}
	}

	void merge_3_parts(int arr[], int first, int center_1, int center_2, int last) {
		int n1 = center_1 - first + 1;     // Olu�turulan 3 par�an�n eleman say�lar�n� buluyor.
		int n2 = center_2 - center_1;      
		int n3 = last - center_2;        
		                         
		int F[] = new int[n1];   // Her bir par�a i�in yeni birer array olu�turuyoruz.
		int C[] = new int[n2];
		int L[] = new int[n3];

		for (int i = 0; i < n1; ++i)   // Ana arraydeki elemanlar� hangi grupta olduklar�n� kontrol ederek yeni arraylere ekliyoruz.
			F[i] = arr[first + i];
		for (int j = 0; j < n2; ++j)
			C[j] = arr[center_1 + 1 + j];
		for (int p = 0; p < n3; ++p)
			L[p] = arr[center_2 + 1 + p];

		int i = 0, j = 0, p = 0;    // Arraylerin indexleri

		int k = first;  // Ana arrayin indexi
		while (i < n1 && j < n2 && p < n3) {  // 3 arrayde de eleman varsa devam ediyor.
			if (F[i] <= C[j] && F[i] <= L[p]) {  // F arrayindeki eleman en k���k mi diye bakar�z.
					arr[k] = F[i];   // E�er en k���k oysa ana arraydeki ilk eleman� de�i�tirerek s�ralamaya ba�lar�z.
					i++;
				}         
			else {       // F en k���k de�ilse C ve L'dekileri kar��la�t�r�r.
				if (C[j] <= L[p]) {
					arr[k] = C[j];  // C'deki k���kse ana arrayin ilk eleman�na o konur.
					j++;
				}
				else {  // E�er L'deki en k���kse o zaman da ana arrayin ilk eleman�na o de�er konur.
					arr[k] = L[p];
					p++;
				}
			}
			k++;  // k'yi artt�rarak ana arrayi d�zenlemeye devam ederiz.
		}
		// Arraylerden biri bittiyse di�er ikisiyle devam etmeliyiz.
		if (i >= n1) {  // Burada if komutlar�yla hangi arrayin bitti�ine bakar�z.
			while (j < n2 && p < n3) {
				if (C[j] <= L[p]) {   // Sonras�nda kalan 2 arrayi kar��la�t�rarak devam ederiz.
					arr[k] = C[j];
					j++;
				} else {
					arr[k] = L[p];
					p++;
				}
				k++;
			}
		}  
		else if (j >= n2) {
			while (i < n1 && p < n3) {
				if (F[i] <= L[p]) {
					arr[k] = F[i];
					i++;
				} else {
					arr[k] = L[p];
					p++;
				}
				k++;
			}
		}
		else if (p >= n3) {
			while (i < n1 && j < n2) {
				if (F[i] <= C[j]) {
					arr[k] = F[i];
					i++;
				} else {
					arr[k] = C[j];
					j++;
				}
				k++;
			}
		}
        // Geriye tek bir array kal�nca onun elemanlar�n� ana arraye ekleyerek bitiririz.
		while (i < n1) {
			arr[k] = F[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = C[j];
			j++;
			k++;
		}
		
		while (p < n3) {
			arr[k] = L[p];
			p++;
			k++;
		}
	}
	
	void quick_sort_pivot_first(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = partition_pivot_first(arr, first, last);  // �ncelikle t�m array al�narak bir defa bir s�ralama yap�l�r.
            quick_sort_pivot_first(arr, first, pivotIndex - 1);   // Sonra fonksiyonun d�nd�rd��� pivot de�erine bak�larak 
            quick_sort_pivot_first(arr, pivotIndex + 1, last);   // 2 yeni grup olu�turulup fonksiyonlar yeniden �a�r�l�r.
        }  // Array k���k par�alara ayr�l�p kendi i�lerinde tekrar tekrar s�raland�ktan sonra par�alar birle�ir ve s�ral� bir array elde ederiz.
    }

    int partition_pivot_first(int[] arr, int first, int last) {
        int pivot = arr[first];    // Burada pivot her zaman arrayin ilk eleman� olarak se�ilir.
        int i = first + 1; // i de�erini arrayin i�indeki de�erlerin yerlerini de�i�tirirken kullanaca��z. �lk eleman zaten pivot oldu�u i�in 2.elemandan ba�lat�r�z.
        for (int j = i; j <= last; j++) {  // j arrayin i�inde gezmek i�in kullan�l�yor ve en ba�ta i ile ayn� yerden ba�lat�yoruz.
            if (arr[j] < pivot) {    // E�er o an �st�nde bulundu�umuz de�er pivottan k���kse 
                int temp = arr[j];  // i ve j indexlerinin bulundu�u yerlerdeki say�lar yer de�i�tirilir.
                arr[j] = arr[i];
                arr[i] = temp;
                i++;  // Her yer de�i�tirmeden sonra i bir ad�m sa�a kayd�r�l�r.
            }
        }
        int temp = arr[first]; // T�m array gezildikten sonra i'nin solundaki say� ile pivot yer de�i�tirilir.
        arr[first] = arr[i - 1];
        arr[i - 1] = temp; // Arrayi 2 gruba ay�r�rken kullanmak i�in i - 1 de�erini return ederiz. 
        return i - 1;     // �rnek olarak 3, 12, 8, 4, 1, 9, 7 gibi bir array varsa ve i de�eri 3 ise 2 de�eri d�nd�r�l�r ve array 2'nin kar��l�k geldi�i yer olan 8'den b�l�n�r.
    }                    // B�ld���m�z 2 par�a 3, 12 ve 4, 1, 9, 7 �eklinde olur.      
    
    void quick_sort_pivot_random(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = partition_pivot_random(arr, first, last);  // pivot_first fonksiyonu ile ayn� i�lemler yap�l�r yaln�zca birka� k���k fark bulunuyor.
            quick_sort_pivot_random(arr, first, pivotIndex - 1);
            if(pivotIndex < last)  // Burada �nceki fonksiyondan farkl� olarak i - 1 de�il i de�eri d�nd�r�lmektedir. 
            	quick_sort_pivot_random(arr, pivotIndex + 1, last);  // Bu y�zden pivotIndex + 1 k�sm�nda arrayin ta�mamas� i�in bir kontrol yap�l�r.
        }
    }

    int partition_pivot_random(int[] arr, int first, int last) {
    	Random random = new Random();  // Fonksiyon i�ine g�nderilen k�s�mdan random bir index se�ilir.
        int rnd = random.nextInt(last - first + 1) + first;
        int pivot = arr[rnd];  // Bu indexe kar��l�k gelen k�s�m pivot de�erimiz olur. 
        int i = first;  // Bu sefer pivot de�erimiz random se�ildi�i i�in i'yi ba�lang�� eleman�ndan ba�lat�r�z.
        for (int j = i; j <= last; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];  // Burada yukar�dakiyle ayn� kontrol yap�larak yine i ve j de�erleri yer de�i�tirilir. 
                arr[j] = arr[i];
                arr[i] = temp;
                if(i == rnd)    // Bu fonksiyonda pivot de�erin indexini tutmam�z gerekiyor 
            		rnd = j;   // bu y�zden i de�eri pivot indexine e�itse pivot indexi pivotun yeni yerle�tirildi�i yer olan j'ye e�itlenir.
                i++;
            }
        }
        
        arr[rnd] = arr[i];  // Bu sefer i'nin �st�nde bulundu�u eleman ile pivot yer de�i�tirilir.
        arr[i] = pivot;
        return i;  // Sonra i de�eri return edilir.
    }
    
    void quick_sort_pivot_mid(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = partition_pivot_mid(arr, first, last);
            quick_sort_pivot_mid(arr, first, pivotIndex - 1);
            if(pivotIndex < last) 
            	quick_sort_pivot_mid(arr, pivotIndex + 1, last);
        }
    }

    int partition_pivot_mid(int[] arr, int first, int last) {
    	int mid = (first + last) / 2;   // Arrayin mid, first ve last elemanlar� kar��la�t�r�larak ���n�n ortas�ndaki de�er pivot olarak se�ilir.
    	int mid_of = 0;                // Fonksiyonun geri kalan k�sm� �stteki fonksiyon ile tamamen ayn� mant�kta �al��maktad�r.
    	                              // Burada da yine se�ilen de�erin indexi �nceden belli olmad���ndan random i�in kulland���m�z algoritma do�ru sonucu vermektedir.
    	if((arr[first] <= arr[mid] && arr[first] >= arr[last]) || (arr[first] <= arr[last] && arr[first] >= arr[mid])) 
    		mid_of = first;
    	if((arr[mid] <= arr[first] && arr[mid] >= arr[last]) || (arr[mid] <= arr[last] && arr[mid] >= arr[first])) 
    		mid_of = mid;
    	if((arr[last] <= arr[mid] && arr[last] >= arr[first]) || (arr[last] <= arr[first] && arr[last] >= arr[mid])) 
    		mid_of = last;
    	
        int pivot = arr[mid_of];
        int i = first;
        for (int j = i; j <= last; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                if(i == mid_of)
            		mid_of = j;
                i++;
            }
        }
        
        arr[mid_of] = arr[i];
        arr[i] = pivot;
        return i;
    }

}
