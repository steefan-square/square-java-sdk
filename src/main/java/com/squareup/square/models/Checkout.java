
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Checkout type.
 */
public class Checkout {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String checkoutPageUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean askForShippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String merchantSupportEmail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String prePopulateBuyerEmail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address prePopulateShippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String redirectUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Order order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<AdditionalRecipient> additionalRecipients;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  checkoutPageUrl  String value for checkoutPageUrl.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
     * @param  prePopulateShippingAddress  Address value for prePopulateShippingAddress.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  order  Order value for order.
     * @param  createdAt  String value for createdAt.
     * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
     */
    @JsonCreator
    public Checkout(
            @JsonProperty("id") String id,
            @JsonProperty("checkout_page_url") String checkoutPageUrl,
            @JsonProperty("ask_for_shipping_address") Boolean askForShippingAddress,
            @JsonProperty("merchant_support_email") String merchantSupportEmail,
            @JsonProperty("pre_populate_buyer_email") String prePopulateBuyerEmail,
            @JsonProperty("pre_populate_shipping_address") Address prePopulateShippingAddress,
            @JsonProperty("redirect_url") String redirectUrl,
            @JsonProperty("order") Order order,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients) {
        this.id = id;
        this.checkoutPageUrl = checkoutPageUrl;
        this.askForShippingAddress = askForShippingAddress;
        this.merchantSupportEmail = merchantSupportEmail;
        this.prePopulateBuyerEmail = prePopulateBuyerEmail;
        this.prePopulateShippingAddress = prePopulateShippingAddress;
        this.redirectUrl = redirectUrl;
        this.order = order;
        this.createdAt = createdAt;
        this.additionalRecipients = additionalRecipients;
    }

    /**
     * Getter for Id.
     * ID generated by Square Checkout when a new checkout is requested.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for CheckoutPageUrl.
     * The URL that the buyer's browser should be redirected to after the checkout is completed.
     * @return Returns the String
     */
    @JsonGetter("checkout_page_url")
    public String getCheckoutPageUrl() {
        return checkoutPageUrl;
    }

    /**
     * Getter for AskForShippingAddress.
     * If `true`, Square Checkout will collect shipping information on your behalf and store that
     * information with the transaction information in your Square Dashboard. Default: `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("ask_for_shipping_address")
    public Boolean getAskForShippingAddress() {
        return askForShippingAddress;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address to display on the Square Checkout confirmation page and confirmation email
     * that the buyer can use to contact the merchant. If this value is not set, the confirmation
     * page and email will display the primary email address associated with the merchant's Square
     * account. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("merchant_support_email")
    public String getMerchantSupportEmail() {
        return merchantSupportEmail;
    }

    /**
     * Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is pre-populated on the checkout page as an editable text
     * field. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("pre_populate_buyer_email")
    public String getPrePopulateBuyerEmail() {
        return prePopulateBuyerEmail;
    }

    /**
     * Getter for PrePopulateShippingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("pre_populate_shipping_address")
    public Address getPrePopulateShippingAddress() {
        return prePopulateShippingAddress;
    }

    /**
     * Getter for RedirectUrl.
     * The URL to redirect to after checkout is completed with `checkoutId`, Square's `orderId`,
     * `transactionId`, and `referenceId` appended as URL parameters. For example, if the provided
     * redirect_url is `http://www.example.com/order-complete`, a successful transaction redirects
     * the customer to:
     * &lt;pre&gt;&lt;code&gt;http://www.example.com/order-complete?checkoutId=xxxxxx&amp;orderId=xxxxxx&amp;referenceId=xxxxxx&amp;transactionId=xxxxxx&lt;/code&gt;&lt;/pre&gt;
     * If you do not provide a redirect URL, Square Checkout will display an order confirmation page
     * on your behalf; however Square strongly recommends that you provide a redirect URL so you can
     * verify the transaction results and finalize the order through your existing/normal
     * confirmation workflow.
     * @return Returns the String
     */
    @JsonGetter("redirect_url")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. `Order` objects also include information about
     * any associated tenders, refunds, and returns. All Connect V2 Transactions have all been
     * converted to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    public Order getOrder() {
        return order;
    }

    /**
     * Getter for CreatedAt.
     * The time when the checkout was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this checkout. For
     * example, fees assessed on the purchase by a third party integration.
     * @return Returns the List of AdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return additionalRecipients;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkoutPageUrl, askForShippingAddress, merchantSupportEmail,
                prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl, order, createdAt,
                additionalRecipients);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(checkoutPageUrl, other.checkoutPageUrl)
            && Objects.equals(askForShippingAddress, other.askForShippingAddress)
            && Objects.equals(merchantSupportEmail, other.merchantSupportEmail)
            && Objects.equals(prePopulateBuyerEmail, other.prePopulateBuyerEmail)
            && Objects.equals(prePopulateShippingAddress, other.prePopulateShippingAddress)
            && Objects.equals(redirectUrl, other.redirectUrl)
            && Objects.equals(order, other.order)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(additionalRecipients, other.additionalRecipients);
    }

    /**
     * Converts this Checkout into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Checkout [" + "id=" + id + ", checkoutPageUrl=" + checkoutPageUrl
                + ", askForShippingAddress=" + askForShippingAddress + ", merchantSupportEmail="
                + merchantSupportEmail + ", prePopulateBuyerEmail=" + prePopulateBuyerEmail
                + ", prePopulateShippingAddress=" + prePopulateShippingAddress + ", redirectUrl="
                + redirectUrl + ", order=" + order + ", createdAt=" + createdAt
                + ", additionalRecipients=" + additionalRecipients + "]";
    }

    /**
     * Builds a new {@link Checkout.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Checkout.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .checkoutPageUrl(getCheckoutPageUrl())
                .askForShippingAddress(getAskForShippingAddress())
                .merchantSupportEmail(getMerchantSupportEmail())
                .prePopulateBuyerEmail(getPrePopulateBuyerEmail())
                .prePopulateShippingAddress(getPrePopulateShippingAddress())
                .redirectUrl(getRedirectUrl())
                .order(getOrder())
                .createdAt(getCreatedAt())
                .additionalRecipients(getAdditionalRecipients());
        return builder;
    }

    /**
     * Class to build instances of {@link Checkout}.
     */
    public static class Builder {
        private String id;
        private String checkoutPageUrl;
        private Boolean askForShippingAddress;
        private String merchantSupportEmail;
        private String prePopulateBuyerEmail;
        private Address prePopulateShippingAddress;
        private String redirectUrl;
        private Order order;
        private String createdAt;
        private List<AdditionalRecipient> additionalRecipients;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for checkoutPageUrl.
         * @param  checkoutPageUrl  String value for checkoutPageUrl.
         * @return Builder
         */
        public Builder checkoutPageUrl(String checkoutPageUrl) {
            this.checkoutPageUrl = checkoutPageUrl;
            return this;
        }

        /**
         * Setter for askForShippingAddress.
         * @param  askForShippingAddress  Boolean value for askForShippingAddress.
         * @return Builder
         */
        public Builder askForShippingAddress(Boolean askForShippingAddress) {
            this.askForShippingAddress = askForShippingAddress;
            return this;
        }

        /**
         * Setter for merchantSupportEmail.
         * @param  merchantSupportEmail  String value for merchantSupportEmail.
         * @return Builder
         */
        public Builder merchantSupportEmail(String merchantSupportEmail) {
            this.merchantSupportEmail = merchantSupportEmail;
            return this;
        }

        /**
         * Setter for prePopulateBuyerEmail.
         * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
         * @return Builder
         */
        public Builder prePopulateBuyerEmail(String prePopulateBuyerEmail) {
            this.prePopulateBuyerEmail = prePopulateBuyerEmail;
            return this;
        }

        /**
         * Setter for prePopulateShippingAddress.
         * @param  prePopulateShippingAddress  Address value for prePopulateShippingAddress.
         * @return Builder
         */
        public Builder prePopulateShippingAddress(Address prePopulateShippingAddress) {
            this.prePopulateShippingAddress = prePopulateShippingAddress;
            return this;
        }

        /**
         * Setter for redirectUrl.
         * @param  redirectUrl  String value for redirectUrl.
         * @return Builder
         */
        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        /**
         * Setter for order.
         * @param  order  Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }

        /**
         * Builds a new {@link Checkout} object using the set fields.
         * @return {@link Checkout}
         */
        public Checkout build() {
            return new Checkout(id, checkoutPageUrl, askForShippingAddress, merchantSupportEmail,
                    prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl, order,
                    createdAt, additionalRecipients);
        }
    }
}
