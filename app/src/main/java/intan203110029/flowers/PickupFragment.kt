package intan203110029.flowers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentPickupBinding
import intan203110029.flowers.model.OrderViewModel

/**
 * [PickupFragment] digunakan utuk memilih tanggal pesanan
 */
class PickupFragment : Fragment() {

    // instan objek binding yang sesui dengan layout  fragment_flavor.xml
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentPickupBinding? = null

    //menggunakan 'by activityViewModels()' sebagai delegasi(mengambil/penyetel dan menangani perubahan)
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            pickupFragment = this@PickupFragment
        }
    }

    /**
     * Navigate untuk ke halaman selanjutnya(ke detail pesanan )
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
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