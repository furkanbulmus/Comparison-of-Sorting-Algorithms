import java.util.Random;

public class SortingClass {

	void merge_sort_2_parts(int arr[], int first, int last) {
		if (first < last) {
			int center = (first + last) / 2;   // Ýkiye bölüm iþlemini yapacaðýmýz merkez noktayý belirleriz.

			merge_sort_2_parts(arr, first, center);     // Ýlk eleman ve merkeze kadar olan kýsým ilk parça, merkezden 1 adým sonraki elemandan son elemana
			merge_sort_2_parts(arr, center + 1, last);     // kadar olan kýsým da ikinci parça olur ve bunlarý yeniden ayný fonksiyonla çaðýrýrýz.

			merge_2_parts(arr, first, center, last);   // Dizideki elemanlarýn sýralanmasý iþlemini bu fonksiyon yapar.
		}
	}

	void merge_2_parts(int arr[], int first, int center, int last) {
		int n1 = center - first + 1;   // Ýlk parçanýn eleman sayýsý
		int n2 = last - center;        // Ýkinci parçanýn eleman sayýsý
		                            
		int F[] = new int[n1];    // Parçalarý tutmak için 2 yeni array oluþtururuz.
		int L[] = new int[n2];

		for (int i = 0; i < n1; ++i)  // Merkeze kadar olan elemanlarý ilk arraye,
			F[i] = arr[first + i];    // merkezden sonrakileri ise ikinci arraye atarýz.
		for (int j = 0; j < n2; ++j)
			L[j] = arr[center + 1 + j];

		int i = 0, j = 0;    // Açtýðýmýz iki arrayin indexleri

		int k = first;
		while (i < n1 && j < n2) {     // Ýki arrayde de eleman varsa döngü devam eder. 
			if (F[i] <= L[j]) {       // Hangi arraydeki eleman daha küçükse onu alýp ana arrayde ilk elemanýn olduðu yere koyarýz.
				arr[k] = F[i];       // Sonra ana arrayin indexi olan k 1 tane büyür ve karþýlaþtýrmaya devam ederek ana arrayi doldururuz.
				i++;
			} else {
				arr[k] = L[j];
				j++;
			}
			k++;
		}

		while (i < n1) {       // Eðer arraylerden birinin eleman sayýsý biterse diðer arraydeki elemanlarla devam ederiz. 
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
			int center_1 = first + (last - first) / 3;       // Bu sefer 3 grup oluþturacaðýmýz için 2 tane noktaya ihtiyacýmýz var.
			int center_2 = first + 2 * (last - first) / 3;   // Bu iþlemlerle gruplarý eþit bölecek 2 nokta belirliyoruz.

			merge_sort_3_parts(arr, first, center_1);          // Belirlediðimiz noktalar, ilk eleman ve son eleman arasýnda 3 gruba bölüyoruz.
			merge_sort_3_parts(arr, center_1 + 1, center_2);                           
			merge_sort_3_parts(arr, center_2 + 1, last);

			merge_3_parts(arr, first, center_1, center_2, last);    // Sýralama için yolluyoruz.
		}
	}

	void merge_3_parts(int arr[], int first, int center_1, int center_2, int last) {
		int n1 = center_1 - first + 1;     // Oluþturulan 3 parçanýn eleman sayýlarýný buluyor.
		int n2 = center_2 - center_1;      
		int n3 = last - center_2;        
		                         
		int F[] = new int[n1];   // Her bir parça için yeni birer array oluþturuyoruz.
		int C[] = new int[n2];
		int L[] = new int[n3];

		for (int i = 0; i < n1; ++i)   // Ana arraydeki elemanlarý hangi grupta olduklarýný kontrol ederek yeni arraylere ekliyoruz.
			F[i] = arr[first + i];
		for (int j = 0; j < n2; ++j)
			C[j] = arr[center_1 + 1 + j];
		for (int p = 0; p < n3; ++p)
			L[p] = arr[center_2 + 1 + p];

		int i = 0, j = 0, p = 0;    // Arraylerin indexleri

		int k = first;  // Ana arrayin indexi
		while (i < n1 && j < n2 && p < n3) {  // 3 arrayde de eleman varsa devam ediyor.
			if (F[i] <= C[j] && F[i] <= L[p]) {  // F arrayindeki eleman en küçük mi diye bakarýz.
					arr[k] = F[i];   // Eðer en küçük oysa ana arraydeki ilk elemaný deðiþtirerek sýralamaya baþlarýz.
					i++;
				}         
			else {       // F en küçük deðilse C ve L'dekileri karþýlaþtýrýr.
				if (C[j] <= L[p]) {
					arr[k] = C[j];  // C'deki küçükse ana arrayin ilk elemanýna o konur.
					j++;
				}
				else {  // Eðer L'deki en küçükse o zaman da ana arrayin ilk elemanýna o deðer konur.
					arr[k] = L[p];
					p++;
				}
			}
			k++;  // k'yi arttýrarak ana arrayi düzenlemeye devam ederiz.
		}
		// Arraylerden biri bittiyse diðer ikisiyle devam etmeliyiz.
		if (i >= n1) {  // Burada if komutlarýyla hangi arrayin bittiðine bakarýz.
			while (j < n2 && p < n3) {
				if (C[j] <= L[p]) {   // Sonrasýnda kalan 2 arrayi karþýlaþtýrarak devam ederiz.
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
        // Geriye tek bir array kalýnca onun elemanlarýný ana arraye ekleyerek bitiririz.
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
            int pivotIndex = partition_pivot_first(arr, first, last);  // Öncelikle tüm array alýnarak bir defa bir sýralama yapýlýr.
            quick_sort_pivot_first(arr, first, pivotIndex - 1);   // Sonra fonksiyonun döndürdüðü pivot deðerine bakýlarak 
            quick_sort_pivot_first(arr, pivotIndex + 1, last);   // 2 yeni grup oluþturulup fonksiyonlar yeniden çaðrýlýr.
        }  // Array küçük parçalara ayrýlýp kendi içlerinde tekrar tekrar sýralandýktan sonra parçalar birleþir ve sýralý bir array elde ederiz.
    }

    int partition_pivot_first(int[] arr, int first, int last) {
        int pivot = arr[first];    // Burada pivot her zaman arrayin ilk elemaný olarak seçilir.
        int i = first + 1; // i deðerini arrayin içindeki deðerlerin yerlerini deðiþtirirken kullanacaðýz. Ýlk eleman zaten pivot olduðu için 2.elemandan baþlatýrýz.
        for (int j = i; j <= last; j++) {  // j arrayin içinde gezmek için kullanýlýyor ve en baþta i ile ayný yerden baþlatýyoruz.
            if (arr[j] < pivot) {    // Eðer o an üstünde bulunduðumuz deðer pivottan küçükse 
                int temp = arr[j];  // i ve j indexlerinin bulunduðu yerlerdeki sayýlar yer deðiþtirilir.
                arr[j] = arr[i];
                arr[i] = temp;
                i++;  // Her yer deðiþtirmeden sonra i bir adým saða kaydýrýlýr.
            }
        }
        int temp = arr[first]; // Tüm array gezildikten sonra i'nin solundaki sayý ile pivot yer deðiþtirilir.
        arr[first] = arr[i - 1];
        arr[i - 1] = temp; // Arrayi 2 gruba ayýrýrken kullanmak için i - 1 deðerini return ederiz. 
        return i - 1;     // Örnek olarak 3, 12, 8, 4, 1, 9, 7 gibi bir array varsa ve i deðeri 3 ise 2 deðeri döndürülür ve array 2'nin karþýlýk geldiði yer olan 8'den bölünür.
    }                    // Böldüðümüz 2 parça 3, 12 ve 4, 1, 9, 7 þeklinde olur.      
    
    void quick_sort_pivot_random(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIndex = partition_pivot_random(arr, first, last);  // pivot_first fonksiyonu ile ayný iþlemler yapýlýr yalnýzca birkaç küçük fark bulunuyor.
            quick_sort_pivot_random(arr, first, pivotIndex - 1);
            if(pivotIndex < last)  // Burada önceki fonksiyondan farklý olarak i - 1 deðil i deðeri döndürülmektedir. 
            	quick_sort_pivot_random(arr, pivotIndex + 1, last);  // Bu yüzden pivotIndex + 1 kýsmýnda arrayin taþmamasý için bir kontrol yapýlýr.
        }
    }

    int partition_pivot_random(int[] arr, int first, int last) {
    	Random random = new Random();  // Fonksiyon içine gönderilen kýsýmdan random bir index seçilir.
        int rnd = random.nextInt(last - first + 1) + first;
        int pivot = arr[rnd];  // Bu indexe karþýlýk gelen kýsým pivot deðerimiz olur. 
        int i = first;  // Bu sefer pivot deðerimiz random seçildiði için i'yi baþlangýç elemanýndan baþlatýrýz.
        for (int j = i; j <= last; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];  // Burada yukarýdakiyle ayný kontrol yapýlarak yine i ve j deðerleri yer deðiþtirilir. 
                arr[j] = arr[i];
                arr[i] = temp;
                if(i == rnd)    // Bu fonksiyonda pivot deðerin indexini tutmamýz gerekiyor 
            		rnd = j;   // bu yüzden i deðeri pivot indexine eþitse pivot indexi pivotun yeni yerleþtirildiði yer olan j'ye eþitlenir.
                i++;
            }
        }
        
        arr[rnd] = arr[i];  // Bu sefer i'nin üstünde bulunduðu eleman ile pivot yer deðiþtirilir.
        arr[i] = pivot;
        return i;  // Sonra i deðeri return edilir.
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
    	int mid = (first + last) / 2;   // Arrayin mid, first ve last elemanlarý karþýlaþtýrýlarak üçünün ortasýndaki deðer pivot olarak seçilir.
    	int mid_of = 0;                // Fonksiyonun geri kalan kýsmý üstteki fonksiyon ile tamamen ayný mantýkta çalýþmaktadýr.
    	                              // Burada da yine seçilen deðerin indexi önceden belli olmadýðýndan random için kullandýðýmýz algoritma doðru sonucu vermektedir.
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
