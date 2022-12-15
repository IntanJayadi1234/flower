package intan203110029.flowers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentFlavorBinding
import intan203110029.flowers.model.OrderViewModel

// menggunakan binding
// digunakan untuk memilih jenis bungan
class FlavorFragment : Fragment() {

    // instan objek binding yang sesui dengan layout  fragment_flavor.xml
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentFlavorBinding? = null

    // menggunakan  'by activityViewModels()' sebagai delegasi(mengambil/penyetel dan menangani perubahan) sebagai referensi ke model tampilan sebagai variable class
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // fragment sebagai pemilik lifecycle
            lifecycleOwner = viewLifecycleOwner

            //  view model sebagai properti dalam class binding
            viewModel = sharedViewModel

            // mengatur fragment
            flavorFragment = this@FlavorFragment
        }
    }

    /**
     * Navigate untuk berpindah ke halaman selanjutnya(ke pilih tanggal pengambilan)
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
    }

    /**
     *  method fragment lifecycle digunakan seperti fragment/aktivitas untuk ke halaman lain
     * digunakan untuk menghapus atau mengganti tampilan
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}