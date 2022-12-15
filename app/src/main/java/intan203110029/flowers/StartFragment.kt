package intan203110029.flowers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentStartBinding
import intan203110029.flowers.model.OrderViewModel

/**
 * tampilan awal halaman aplikasi
 * memilih berapa banyak yang akan diorder
 */
class StartFragment : Fragment() {

    // instan objek binding yang sesui dengan layout  fragment_flavor.xml
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentStartBinding? = null

    // menggunakan 'by activityViewModels()' sebagai delegasi(mengambil/penyetel dan menangani perubahan)
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    /**
     * awal order dengan memilih jumlah yang akan dipesan
     * kemudian akan pindah ke halamnan selanjutnya (ke pilih jenis bunag)
     */
    fun orderCupcake(quantity: Int) {
        // mengupdate view model dengan quantity (jumlah)
        sharedViewModel.setQuantity(quantity)

        // jika jenis tidak dipilih maka pilihan akan default yaitu mawar merah
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }

        // Navigate untuk ke halaman selajutnya (ke pilih jenis bunga)
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }

    /**
     * method fragment lifecycle digunakan seperti fragment/aktivitas untuk ke halaman lain
     * digunakan untuk menghapus atau mengganti tampilan
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}