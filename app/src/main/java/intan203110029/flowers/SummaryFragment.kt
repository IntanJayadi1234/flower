package intan203110029.flowers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cupcake.databinding.FragmentSummaryBinding
import intan203110029.flowers.model.OrderViewModel

/**
 * tentang detail pesanan yang akan di share ke aplikasi lain
 */
class SummaryFragment : Fragment() {

    // instan objek binding yang sesui dengan layout  fragment_flavor.xml
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentSummaryBinding? = null

    // menggunakan 'by activityViewModels()' sebagai delegasi(mengambil/penyetel dan menangani perubahan)
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
        }
    }

    /**
     * mengirim orderan ke aplikasi lain
     * dengan meenggunakan intent implicit
     */
    fun sendOrder() {
        Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
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