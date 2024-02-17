import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfood.databinding.CartItemBinding

class CartAdapter(private val cartItems: MutableList<String>, private val cartItemPrice: MutableList<String>, private val cartImage: MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int)
        {
            binding.apply {
                val quantity = itemQuantities[position]
                idTVCartItemName.text = cartItems[position]
                idTVCardItemPrice.text=cartItemPrice[position]
                idimgCartImage.setImageResource(cartImage[position])
                idTVQuantity.text = quantity.toString()
            }
        }
    }
}
